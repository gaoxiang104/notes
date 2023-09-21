package pers.xgo.onjava.chapter17_files;
// 分析 Path

import java.io.IOException;
import java.nio.file.*;

public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.println(id + ": " + result);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));

        Path p = Paths.get("src/main/java/pers/xgo/onjava/chapter17_files/PathAnalysis.java")
                .toAbsolutePath();

        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p)); // 是否可执行
        say("Readable", Files.isReadable(p)); // 是否可读
        say("Writable", Files.isWritable(p)); // 是否可写
        say("notExists", Files.notExists(p)); // 不存在
        say("hidden", Files.isHidden(p)); // 是否隐藏文件
        say("size", Files.size(p)); // 文件大小
        say("FileStore", Files.getFileStore(p)); // 用于获取与给定路径相关联的文件存储（FileStore）对象。FileStore 表示文件系统或磁盘分区，并提供了关于存储设备的信息，例如文件系统类型、总容量、可用容量、文件系统支持的特性等。
        say("LastModified", Files.getLastModifiedTime(p)); // 最后修改时间
        say("Owner", Files.getOwner(p)); // 文件所属物主
        say("ContentType", Files.probeContentType(p)); // 用于获取与指定文件相关的 MIME 类型（媒体类型）
        say("SymbolicLink", Files.isSymbolicLink(p)); // 测试文件是否为符号链接
        if (Files.isSymbolicLink(p)) {
            say("SymbolicLink", Files.readSymbolicLink(p));
        }
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            say("PosixFilePermissions", Files.getPosixFilePermissions(p));
        }
    }
}
