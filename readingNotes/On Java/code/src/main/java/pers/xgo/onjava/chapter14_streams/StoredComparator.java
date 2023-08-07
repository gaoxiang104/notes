package pers.xgo.onjava.chapter14_streams;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Comparator;

public class StoredComparator {
    public static void main(String[] args) throws IOException {
        String filePath = URLDecoder.decode(StoredComparator.class.getResource("Cheese.dat").getPath(), "UTF-8");
        FileToWordsRegexp fw = new FileToWordsRegexp(filePath);

        fw.stream()
                .skip(10)
                .limit(10)
                .sorted(Comparator.reverseOrder())
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
