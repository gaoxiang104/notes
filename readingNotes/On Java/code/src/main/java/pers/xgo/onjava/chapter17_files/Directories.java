package pers.xgo.onjava.chapter17_files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Directories {

    static Path test = Paths.get("/Users/gaoxiang/Downloads/temp/test");
    static String sep = FileSystems.getDefault().getSeparator(); // 系统分隔符
    static List<String> parts = Arrays.asList("foo", "bar", "baz", "bag");

    static Path markVariant() {
        Collections.rotate(parts, 1);
        return Paths.get("/Users/gaoxiang/Downloads/temp/test", String.join(sep, parts));
    }

    static void refreshTestDir() throws Exception {
        if (Files.exists(test)) { // 存在删除
            RmDir.rmdir(test);
        }
        if (Files.notExists(test)) {
            Files.createDirectories(test);
        }
    }

    static void populateTestDir() throws Exception {
        for (int i = 0; i < parts.size(); i++) {
            Path variant = markVariant();
            if (Files.notExists(variant)) {
                Files.createDirectories(variant);
                Files.copy(Paths.get("src/main/java/pers/xgo/onjava/chapter17_files/Directories.java"),
                        variant.resolve("File.txt"));
                Files.createTempFile(variant, null, null);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = markVariant();
        // 抛出异常（层次太多）
        try {
            Files.createDirectories(variant);
        } catch (IOException e) {
            System.out.println("Nope, that doesn't work");
        }

        populateTestDir();
        Path tempDir = Files.createTempDirectory(test,"DIR_");
        Files.createTempFile(tempDir,"pre",".non");
        Files.newDirectoryStream(test).forEach(System.out::println);
        System.out.println("*****************");
        Files.walk(test).forEach(System.out::println);
    }
}
