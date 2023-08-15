package pers.xgo.onjava.chapter14_streams;

public class ForEach {
    static final int SZ = 14;

    public static void main(String[] args) {
        RandInts.rands()
                .limit(SZ)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        RandInts.rands()
                .limit(SZ)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        RandInts.rands()
                .limit(SZ)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));
    }
}
/* OUTPUT:
258 555 693 861 961 429 868 200 522 207 288 128 551 589
551 589 861 868 555 693 258 961 200 288 429 207 522 128
258 555 693 861 961 429 868 200 522 207 288 128 551 589
 */