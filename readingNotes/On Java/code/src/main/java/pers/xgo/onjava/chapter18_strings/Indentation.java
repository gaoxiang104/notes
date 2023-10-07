package pers.xgo.onjava.chapter18_strings;

public class Indentation {
    public static final String NONE = """
            XXX
            YYY
            """; // 没有缩进

    public static final String TWO = """
            XXX
            YYY
          """; // 产生2个缩进

    public static final String EIGHT = """
            XXX
            YYY
    """; // 产生8个缩进

    public static void main(String[] args) {
        System.out.println(NONE);
        System.out.println(TWO);
        System.out.println(EIGHT);
    }
}
