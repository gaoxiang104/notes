package pers.xgo.onjava.chapter12_collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 获取文件中的所有单词
public class UniqueWords {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("E:\\Projects\\github\\notes\\hsp\\1_java_basics\\code2\\src\\main\\java\\org\\gx\\onjava\\charpter12_collections\\SetOperations.java"));
        Set<String> words = new HashSet<>();
        for (String line : lines) {
            for (String word : line.split("\\W+")) {
                if (word.trim().length() > 0){
                    words.add(word);
                }
            }
        }
        System.out.println(words);
    }
}
