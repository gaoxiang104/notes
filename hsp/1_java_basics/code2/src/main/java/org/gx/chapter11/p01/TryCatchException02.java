package org.gx.chapter11.p01;


public class TryCatchException02 {
    public static int method() {
        int i = 1;
        try {
            i++;
            String[] names = new String[3];
            if (names[1].equals("tom")) {
                System.out.println(names[1]);
            } else {
                names[3] = "abc";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        } catch (NullPointerException e) {
            return ++i; // i = 3 => 保存到临时变量 temp = 3;
        } finally {
            ++i;
            System.out.println("finally i = " + i);
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}

