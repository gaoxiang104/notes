package pers.xgo.onjava.chapter15_exceptions;

// {NewFeature} 从 JDK 9 开始

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EffectivelyFinalTWR {
    static void old() {
        try (
                InputStream r1 = new FileInputStream(new File("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/src/main/java/pers/xgo/onjava/chapter15_exceptions/EffectivelyFinalTWR.java"));
                InputStream r2 = new FileInputStream(new File("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/src/main/java/pers/xgo/onjava/chapter15_exceptions/EffectivelyFinalTWR.java"));
        ) {
            r1.read();
            r2.read();
        } catch (IOException e) {
            // 处理异常
        }
    }

    static void jdk9() throws IOException {
        final InputStream r1 = new FileInputStream(new File("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/src/main/java/pers/xgo/onjava/chapter15_exceptions/EffectivelyFinalTWR.java"));
        final InputStream r2 = new FileInputStream(new File("/Users/gaoxiang/Projects/github/notes/readingNotes/On Java/code/src/main/java/pers/xgo/onjava/chapter15_exceptions/EffectivelyFinalTWR.java"));
        try (r1; r2) {
            r1.read();
            r2.read();
        }
        // r1 和 r2 仍然在作用域中
        // 访问其中的任何一个都会抛出异常：
        r1.read();
        r2.read();
    }

    public static void main(String[] args) {
        old();
        try {
            jdk9();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
