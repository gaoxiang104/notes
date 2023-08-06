package pers.xgo.onjava.chapter14_streams;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileToWordsRegexp {
    private String all;

    public FileToWordsRegexp(String filePath) throws IOException {
        all = Files.lines(Path.of(filePath))
                .skip(1)
                .collect(Collectors.joining(" "));
    }

    public Stream<String> stream(){
        return Pattern.compile("[ .?,]+").splitAsStream(all);
    }

    public static void main(String[] args) throws IOException {
        String filePath = URLDecoder.decode(FileToWordsRegexp.class.getResource("Cheese.dat").getPath(),"UTF-8");
        FileToWordsRegexp fw = new FileToWordsRegexp(filePath);
        fw.stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);

        fw.stream()
                .skip(7)
                .limit(2)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
