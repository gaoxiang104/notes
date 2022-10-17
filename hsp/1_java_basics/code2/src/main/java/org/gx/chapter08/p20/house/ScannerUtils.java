package org.gx.chapter08.p20.house;

import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 输入字符串
     *
     * @return
     */
    public static String readString() {
        return scanner.next();
    }

    public static int readInt() {
        return scanner.nextInt();
    }

    public static double readDouble() {
        return scanner.nextDouble();
    }

    /**
     * 输入字符串
     *
     * @return
     */
    public static String readString(int limit) {
        String result = readString();
        if (result.length() > limit) {
            return "要求输入一个字符串，长度最大为" + limit;
        }
        return result;
    }

    public static boolean confirmRead(String text) {
        boolean flag = true;
        String in = "";
        while (flag) {
            System.out.println(text + " y/n");
            in = readString();
            if ("y".equals(in) || "n".equals(in)) {
                flag = false;
            }
        }

        return "y".equals(in);
    }

    public static boolean confirmExitSys() {
        return confirmRead("请确认是否要退出系统？");
    }

    public static void main(String[] args) {
//        String s = ScannerUtils.readString(3);
//        System.out.println(s);
        System.out.println(confirmExitSys());
    }
}
