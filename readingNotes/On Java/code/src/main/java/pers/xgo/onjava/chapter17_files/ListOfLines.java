package pers.xgo.onjava.chapter17_files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListOfLines {
    public static void main(String[] args) throws Exception {
        Files.readAllLines(
                        Paths.get("src/main/resources/pers/xgo/onjava/chapter14_streams/Cheese.dat"))
                .stream()
                .filter(line -> !line.startsWith("//"))
                .map(line -> line.substring(0, line.length() / 2))
                .forEach(System.out::println);
    }
}
