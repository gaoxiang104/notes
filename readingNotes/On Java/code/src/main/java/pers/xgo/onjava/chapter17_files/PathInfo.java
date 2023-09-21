package pers.xgo.onjava.chapter17_files;

import java.io.*;
import java.net.URI;
import java.nio.file.*;

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + p);
    }

    static void info(Path p) {
        show("toString:\n ", p);
        show("Exists: ", Files.exists(p)); // 文件是否存在
        show("RegularFile: ", Files.isRegularFile(p)); // 是否常规文件
        show("Directory: ", Files.isDirectory(p)); // 是否是目录
        show("Absolute: ", p.isAbsolute()); // path 是否是完整的绝对路径
        show("FileName: ", p.getFileName()); // 获取文件名
        show("Parent: ", p.getParent()); // 获取父目录
        show("Root: ", p.getRoot()); // 将此路径的根组件作为path对象返回，如果此路径没有根组件，则返回null。
        System.out.println("************************");
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));

        info(Paths.get("c:", "path", "to", "nowhere", "NoFile.txt"));

        Path p = Paths.get("src/main/java/pers/xgo/onjava/chapter17_files/PathInfo.java");
        info(p);

        Path ap = p.toAbsolutePath();
        info(ap);
        info(ap.getParent());

        try {
            info(p.toRealPath()); // 真实路径
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        URI u = p.toUri();
        System.out.println("URI:\n " + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile();  // 不要被骗
    }
}
