package pers.xgo.onjava.chapter14_streams;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

public class SpecialCollector {
    public static void main(String[] args) throws IOException {
        String filePath = URLDecoder.decode(FileToWordsTest.class.getResource("Cheese.dat").getPath(), "UTF-8");

        ArrayList<String> words =
                FileToWords.stream(filePath)
                        .collect(ArrayList::new
                                , ArrayList::add
                                , ArrayList::addAll);

        words.stream().filter(s -> s.equals("cheese")).forEach(System.out::println);
    }
}
