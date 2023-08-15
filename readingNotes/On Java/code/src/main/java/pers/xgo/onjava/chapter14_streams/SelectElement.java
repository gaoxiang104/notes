package pers.xgo.onjava.chapter14_streams;

public class SelectElement {
    public static void main(String[] args) {
        System.out.println(RandInts.rands().findFirst().getAsInt());
        System.out.println(RandInts.rands().parallel().findFirst().getAsInt()); // 并发
        System.out.println(RandInts.rands().findAny().getAsInt());
        System.out.println(RandInts.rands().parallel().findAny().getAsInt()); // 并发
    }
}
/* output:
258
258
258
242
 */