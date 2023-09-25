package pers.xgo.onjava.chapter17_files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    public static void main(String[] args) throws Exception {
        Directories.refreshTestDir();

        Random rand = new Random(47);
        // 将字节写入一个文件
        byte[] bytes = new byte[1000];
        rand.nextBytes(bytes);

        Path bytesDat = Paths.get("/Users/gaoxiang/Downloads/temp/test").resolve("bytes.dat");
        Files.write(bytesDat, bytes);
        System.out.println("bytes.dat: " + Files.size(bytesDat));

        // 将实现了 Iterable 接口的类的对象写入一个文件：
        List<String> lines = Files.readAllLines(Paths.get("src/main/resources/pers/xgo/onjava/chapter14_streams/Cheese.dat"));
        Path cheese = Paths.get("/Users/gaoxiang/Downloads/temp/test").resolve("Cheese.txt");
        Files.write(cheese, lines);
        System.out.println("Cheese.txt: " + Files.size(cheese));

    }
}
