package pers.xgo.onjava.chapter16_validating;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.*;

public class DynamicStringInverterTest {
    // 组合操作来访问重复代码
    Stream<DynamicTest> testVersions(String id,
                                     Function<StringInverter, String> test) {
        List<StringInverter> versions = Arrays.asList(new Inverter1(), new Inverter2(), new Inverter3(), new Inverter4());

        return DynamicTest.stream(versions.stream(),
                inverter -> inverter.getClass().getSimpleName(),
                inverter -> {
                    System.out.println(inverter.getClass().getSimpleName() + " : " + id);

                    try {
                        if (test.apply(inverter) != "fail") {
                            System.out.println("Success");
                        }
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                }
        );
    }

    String isEqual(String lval, String rval) {
        if (lval.equals(rval)) {
            return "success";
        }
        System.out.println("FAIL : " + lval + " != " + rval);
        return "fail";
    }

    @BeforeAll
    static void startMsg() {
        System.out.println(">>> Starting DynamicStringInverterTests <<<");
    }

    @AfterAll
    static void endMsg() {
        System.out.println(">>> Finished DynamicStringInverterTests <<<");
    }

    @TestFactory
    Stream<DynamicTest> basicInversion1() {
        String in = "Exit, Pursued by a Bear.";
        String out = "eXIT, pURSUED BY A bEAR.";
        return testVersions("Basic inversion (should succeed)",
                inverter -> isEqual(inverter.inverter(in), out));
    }

    @TestFactory
    Stream<DynamicTest> basicInversion2() {
        return testVersions("Basic inversion (should fail)",
                inverter -> isEqual(inverter.inverter("X"), "X"));
    }

    @TestFactory
    Stream<DynamicTest> disallowedCharacters() { // 不允许的字符
        String disallowed = ";-_()*&^%$#@!~`1234567890";
        return testVersions(
                "Disallowed characters",
                inverter -> {
                    String result = disallowed.chars()
                            .mapToObj(c -> {
                                String cc = Character.toString((char) c);
                                try {
                                    inverter.inverter(cc);
                                    return "";
                                } catch (RuntimeException e) {
                                    return cc;
                                }

                            }).collect(Collectors.joining(""));

                    if (result.length() == 0) {
                        return "success";
                    }
                    System.out.println("Bad characters: " + result);
                    return "fail";
                }
        );
    }

    @TestFactory
    Stream<DynamicTest> allowedCharacters() {
        String lowcase = "abcdefghijklmnopqrstuvwxyz,.";
        String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ,.";
        return testVersions(
                "Allowed characters (should succeed)",
                inverter -> {
                    assertEquals(inverter.inverter(lowcase), upcase);
                    assertEquals(inverter.inverter(upcase), lowcase);
                    return "success";
                }
        );
    }

    @TestFactory
    Stream<DynamicTest> lengthNoGreaterThan30() {
        String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertTrue(str.length() > 30);
        return testVersions(
                "Length must be less than 31 (throws exception)",
                inverter -> inverter.inverter(str)
        );
    }

    @TestFactory
    Stream<DynamicTest> lengthLessThan31() {
        String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertTrue(str.length() < 31);
        return testVersions(
                "Length must be less than 31 (throws exception)",
                inverter -> inverter.inverter(str)
        );
    }
}
