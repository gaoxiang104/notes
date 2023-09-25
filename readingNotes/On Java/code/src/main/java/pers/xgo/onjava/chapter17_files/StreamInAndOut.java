package pers.xgo.onjava.chapter17_files;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamInAndOut {
    public static void main(String[] args) throws Exception {

        Path txt = Paths.get("/Users/gaoxiang/Downloads/temp/test").resolve("StreamInAndOut.txt");

        try (
                Stream<String> input =
                        Files.lines(Paths.get("src/main/java/pers/xgo/onjava/chapter17_files/StreamInAndOut.java"));
                PrintWriter output = new PrintWriter(txt.toFile())
        ) {
            input.map(String::toUpperCase)
                    .forEachOrdered(output::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
