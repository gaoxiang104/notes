package pers.xgo.onjava.chapter14_streams;

import java.io.IOException;
import java.net.URLDecoder;

public class FileToWordsTest {
    public static void main(String[] args) throws IOException {
        String filePath = URLDecoder.decode(FileToWordsTest.class.getResource("Cheese.dat").getPath(), "UTF-8");
        FileToWords.stream(filePath)
                .limit(7)
                .forEach(s -> System.out.format("%s ", s));
        System.out.println();
        FileToWords.stream(filePath)
                .skip(7)
                .limit(2)
                .forEach(s -> System.out.format("%s ", s));
    }
}
