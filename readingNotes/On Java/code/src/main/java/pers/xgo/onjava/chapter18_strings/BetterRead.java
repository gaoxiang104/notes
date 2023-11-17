package pers.xgo.onjava.chapter18_strings;

import java.util.Scanner;

public class BetterRead {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(SimpleRead.input);
        System.out.println("What is your name?");
        String name = stdin.nextLine();
        System.out.println(name);
        System.out.println("How old are you? " +
                "What is your favorite double?");
        System.out.println("(input: <age> <double>)");
        int age = stdin.nextInt();
        double favorite = stdin.nextDouble();
        System.out.printf("Hi %s.%n", name);
        System.out.printf("In 5 years you will be %d.%n", age + 5);
        System.out.printf("My favorite double is %f.", favorite / 2);
    }
}
