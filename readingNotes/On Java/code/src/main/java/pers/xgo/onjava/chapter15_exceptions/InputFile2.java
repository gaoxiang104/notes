package pers.xgo.onjava.chapter15_exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputFile2 {
    private String fName;

    public InputFile2(String fName) {
        this.fName = fName;
    }

    Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(fName));
    }

    public static void main(String[] args) throws IOException {
        new InputFile2("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/src/main/java/pers/xgo/onjava/chapter15_exceptions/InputFile2.java")
                .getLines()
                .skip(15)
                .limit(1)
                .forEach(System.out::println);
    }
}
