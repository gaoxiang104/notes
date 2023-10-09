package pers.xgo.onjava.chapter18_strings;

public class Replacing {
    public static void main(String[] args) {
        System.out.println(Splitting.KNIGHTS.replaceFirst("f\\w+", "located"));
        System.out.println(Splitting.KNIGHTS.replaceAll("f\\w+", "located"));
    }
}
