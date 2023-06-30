package org.gx.onjava.chapter10_interfaces;

sealed class Color permits Red, Green, Blue {}
final class Red extends Color {}
final class Green extends Color {}
final class Blue extends Color {}

public class PermittedSubclasses {
    public static void main(String[] args) {
        for (Class<?> p : Color.class.getPermittedSubclasses()) {
            System.out.println(p.getSimpleName());
        }
    }
}
