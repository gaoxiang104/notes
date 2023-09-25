package pers.xgo.onjava.chapter17_files;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadLinesStream {
    public static void main(String[] args) throws Exception{
        Files.lines(Paths.get("src/main/java/pers/xgo/onjava/chapter17_files/PathInfo.java"))
                .skip(13)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
