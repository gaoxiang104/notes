package pers.xgo.onjava.chapter15_exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamAreAutoCloseable {
    public static void main(String[] args) {
        try (
                Stream<String> in = Files.lines(Paths.get("StreamAreAutoCloseable.java"));
                PrintWriter outfile = new PrintWriter("Results.txt");
        ) {
            in.skip(5)
                    .limit(1)
                    .map(String::toLowerCase)
                    .forEach(outfile::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
