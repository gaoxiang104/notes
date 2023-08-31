package pers.xgo.onjava.chapter15_exceptions;

import java.io.*;

public class TryWithResources {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream(new File(""))) {
            int contents = in.read();
            // 处理内容
        } catch (IOException e) {
            // 处理异常
        }
    }
}
