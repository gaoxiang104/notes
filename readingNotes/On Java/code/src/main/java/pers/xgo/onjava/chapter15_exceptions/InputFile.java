package pers.xgo.onjava.chapter15_exceptions;
// 注意构造器中的异常

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
    private BufferedReader in;

    public InputFile(String fName) {
        try {
            in = new BufferedReader(new FileReader(fName));
            // 其他可能会抛出异常的代码
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + fName);
            throw new RuntimeException(e);
        } catch (Exception e) {
            try {
                in.close();
            } catch (IOException ex) {
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        } finally {
            // 不要在这里关闭！！
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
