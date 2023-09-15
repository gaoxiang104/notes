package pers.xgo.onjava.chapter16_validating;
// 实现反转操作
import static java.lang.Character.*;

public class Inverter2 implements StringInverter{
    @Override
    public String inverter(String str) {
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result += isUpperCase(c) ? toLowerCase(c) : toUpperCase(c);
        }
        return result;
    }
}
