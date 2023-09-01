package pers.xgo.onjava.chapter15_exceptions;

class Third extends Reporter {
}

public class BodyException {
    public static void main(String[] args) {
        try (
                First f = new First();
                Second s = new Second()
        ) {
            System.out.println("In body");
            Third t = new Third(); // 注意，Third 对象永远不会得到清理。
            new SecondExcept();
            System.out.println("End of body");
        } catch (CE e) {
            System.out.println("Caught: " + e);
        }
    }
}
