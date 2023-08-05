package pers.xgo.onjava.chapter14_streams;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();

    public FileToWordsBuilder(String filePath) throws IOException {
        Files.lines(Paths.get(filePath))
                .skip(1)
                .forEach(line -> {
                    for (String w : line.split("[ .?,]+")) {
                        builder.add(w);
                    }
                });
    }
    Stream<String> stream() {
        return builder.build();
    }

    public static void main(String[] args) throws IOException {
        String path = URLDecoder.decode(FileToWordsBuilder.class.getResource("Cheese.dat").getPath(), "UTF-8");
        new FileToWordsBuilder(path).stream()
                .limit(7)
                .map(w -> w + " ")
                .forEach(System.out::print);
    }
}
