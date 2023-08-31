package pers.xgo.onjava.chapter15_exceptions;

import java.io.*;

public class MessyExceptions {
    public static void main(String[] args) {
        InputStream in = null;
        try {
            in = new FileInputStream(new File(""));
            int contents = in.read();
            // 处理内容
        } catch (IOException e) {
            // 处理错误
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // 处理 close() 错误
                }
            }
        }
    }
}
