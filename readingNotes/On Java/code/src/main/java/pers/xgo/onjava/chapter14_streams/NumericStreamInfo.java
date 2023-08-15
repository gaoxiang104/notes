package pers.xgo.onjava.chapter14_streams;

public class NumericStreamInfo {
    public static void main(String[] args) {
        System.out.println(RandInts.rands().average().getAsDouble());
        System.out.println(RandInts.rands().max().getAsInt());
        System.out.println(RandInts.rands().min().getAsInt());
        System.out.println(RandInts.rands().sum());
        System.out.println(RandInts.rands().summaryStatistics());
    }
}
/* output:
507.94
998
8
50794
IntSummaryStatistics{count=100, sum=50794, min=8, average=507.940000, max=998}
 */