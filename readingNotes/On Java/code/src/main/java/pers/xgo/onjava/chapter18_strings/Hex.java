package pers.xgo.onjava.chapter18_strings;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0) result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws Exception{
        byte[] bytes = Files.readAllBytes(Paths.get("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/target/classes/pers/xgo/onjava/chapter18_strings/Hex.class"));

        System.out.println(format(bytes));
    }
}
