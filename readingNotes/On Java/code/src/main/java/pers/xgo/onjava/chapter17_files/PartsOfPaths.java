package pers.xgo.onjava.chapter17_files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));

        Path p = Paths.get("src/main/java/pers/xgo/onjava/chapter17_files/PartsOfPaths.java").toAbsolutePath();

        for (int i = 0; i < p.getNameCount(); i++) { // 获取每层目录的名字
            System.out.println(p.getName(i));
        }

        System.out.println("ends with '.java' : " + p.endsWith(".java"));

        for (Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }

        System.out.println("Start with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}
