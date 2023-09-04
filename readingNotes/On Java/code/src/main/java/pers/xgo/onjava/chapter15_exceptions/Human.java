package pers.xgo.onjava.chapter15_exceptions;
// {捕捉层次化异常}

class Annoyance extends Exception {
} // 恼怒

class Sneeze extends Annoyance {
} // 打喷嚏

public class Human { // 人类
    public static void main(String[] args) {
        // 捕捉精确的类型
        try {
            throw new Sneeze();
        } catch (Sneeze e) {
            System.out.println("Caught Sneeze");
        } catch (Annoyance e) {
            System.out.println("Caught Annoyance");
        }

        // 捕捉基类类型
        try {
            throw new Sneeze();
        } catch (Annoyance e) {
            System.out.println("Caught Annoyance");
        }
    }
}
