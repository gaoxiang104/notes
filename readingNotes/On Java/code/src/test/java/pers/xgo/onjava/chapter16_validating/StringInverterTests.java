package pers.xgo.onjava.chapter16_validating;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class StringInverterTests {
    StringInverter inverter = new Inverter4();

    @BeforeAll
    static void startMsg() {
        System.out.println(">>> StringInverterTests <<<");
    }

    @Test
    void basicInversion1() {
        String in = "Exit, Pursued by a Bear.";
        String out = "eXIT, pURSUED BY A bEAR.";
        assertEquals(inverter.inverter(in), out);
    }

    @Test
    void basicInversion2() {
        assertThrows(Error.class, () -> {
            assertEquals(inverter.inverter("X"), "X");
        });
    }

    @Test
    void disallowedCharacters() { // 不允许的字符
        String disallowed = ";-_()*&^%$#@!~`1234567890";

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

        assertEquals(result, disallowed);
    }

    @Test
    void allowedCharacters() {
        String lowcase = "abcdefghijklmnopqrstuvwxyz,.";
        String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ,.";
        assertEquals(inverter.inverter(lowcase), upcase);
        assertEquals(inverter.inverter(upcase), lowcase);
    }

    @Test
    void lengthNoGreaterThan30() {
        String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertTrue(str.length() > 30);

        assertThrows(RuntimeException.class, () -> {
            inverter.inverter(str);
        });
    }

    @Test
    void lengthLessThan31(){
        String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        assertTrue(str.length() < 31);
        inverter.inverter(str);
    }
}
