package pers.xgo.onjava.chapter14_streams;

import java.io.IOException;
import java.net.URLDecoder;

public class Peeking {
    public static void main(String[] args) throws IOException {
        String filePath = URLDecoder.decode(Peeking.class.getResource("Cheese.dat").getPath(), "UTF-8");
        FileToWordsRegexp fw = new FileToWordsRegexp(filePath);
        fw.stream()
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print)
        ;
    }
}
/* OUTPUT
Well WELL well it's IT'S it's so SO so clean CLEAN clean
 */
