package pers.xgo.onjava.chapter14_streams;

import java.io.IOException;
import java.net.URLDecoder;

public class Informational {
    public static void main(String[] args) throws IOException {
        String filePath = URLDecoder.decode(FileToWordsTest.class.getResource("Cheese.dat").getPath(), "UTF-8");
        System.out.println(FileToWords.stream(filePath).count());
        System.out.println(FileToWords.stream(filePath).min(String.CASE_INSENSITIVE_ORDER).orElse("NONE"));
        System.out.println(FileToWords.stream(filePath).max(String.CASE_INSENSITIVE_ORDER).orElse("NONE"));

    }
}
