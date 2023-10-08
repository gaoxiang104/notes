package pers.xgo.onjava.chapter18_strings;

public class BackSlashes { // 背面斜线
    public static void main(String[] args) {
        String one = "\\";
        String two = "\\\\";
        String three = "\\\\\\";
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
        System.out.println(one.matches("\\\\"));
        System.out.println(two.matches("\\\\\\\\"));
        System.out.println(three.matches("\\\\\\\\\\\\"));
    }
}
/* OUTPUT
\
\\
\\\
true
true
true
 */