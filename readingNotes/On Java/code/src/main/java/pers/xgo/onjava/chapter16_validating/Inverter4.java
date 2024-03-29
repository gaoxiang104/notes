package pers.xgo.onjava.chapter16_validating;

import static java.lang.Character.*;

public class Inverter4 implements StringInverter{
    static final String ALLOWED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";

    @Override
    public String inverter(String str) {
        if (str.length() > 30) throw new RuntimeException("argument too long!");
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (ALLOWED.indexOf(c) == -1){
                throw new RuntimeException(c + " Not allowed");
            }
            result += isUpperCase(c) ? toLowerCase(c) : toUpperCase(c);
        }
        return result;
    }
}
