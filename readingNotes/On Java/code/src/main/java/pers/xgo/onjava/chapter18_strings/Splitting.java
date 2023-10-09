package pers.xgo.onjava.chapter18_strings;

import java.util.Arrays;

public class Splitting {
    // 骑士
    public static final String KNIGHTS = """
            Then, when you have found the shrubbery, 
            you ust cut down the mightiest tree in the
            forest...with... a herring
            """;

    public static void split(String regex) {
        System.out.println(Arrays.toString(KNIGHTS.split(regex)));
    }

    public static void main(String[] args) {
        split(" "); // 参数里不一定要有正则字符
        split("\\W+"); // 不是单词的字符
        split("n\\W+"); // n 后面跟着一个不是单词的字符
    }
}
