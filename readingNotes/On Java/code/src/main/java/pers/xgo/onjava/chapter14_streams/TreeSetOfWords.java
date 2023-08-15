package pers.xgo.onjava.chapter14_streams;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetOfWords {
    public static void main(String[] args) throws Exception {
        TreeSet<String> words2 = Files.lines(Paths.get("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/src/main/java/pers/xgo/onjava/chapter14_streams/TreeSetOfWords.java"))
                .flatMap(s -> Arrays.stream(s.split("\\W+")))
                .filter(s -> !s.matches("\\d+")) // 不要数字
                .map(String::trim)
                .filter(s -> s.length() > 2)
                .limit(100)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(words2);
    }
}
