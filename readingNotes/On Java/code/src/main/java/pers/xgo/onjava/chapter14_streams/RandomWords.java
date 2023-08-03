package pers.xgo.onjava.chapter14_streams;
// 随机获取文件中的单词

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random random = new Random(47);
    RandomWords(String fname) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(fname));
        // 跳过第一行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+")) { // 解析单词
                words.add(word.toLowerCase());
            }
        }
    }
    @Override
    public String get() {
        return words.get(random.nextInt(words.size()));
    }

    @Override
    public String toString() {
        return words.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws IOException {
        System.out.println(
                Stream.generate(new RandomWords("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/src/main/java/pers/xgo/onjava/chapter14_streams/Cheese.dat"))
                        .limit(10)
                        .collect(Collectors.joining(" "))
        );
    }
}
