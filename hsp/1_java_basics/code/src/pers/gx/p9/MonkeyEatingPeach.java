package pers.gx.p9;

/**
 * 猴子吃桃问题：
 */
public class MonkeyEatingPeach {
    public static void main (String args[]) {
        T t = new T();
        int day = 1;
        int result = t.monkeyEatingPeach(day);
        if(-1 != result){
            System.out.println("第" + day + "天有" + result + "个桃子");
        }
    }
}

class T {
    /*
    猴子吃桃问题：有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个！
    以后每天猴子都吃其中的一半，然后再多吃一个。当到第10天时，想再吃
    时（即还没吃），发现只有1个桃子了。问：最初共有多少个桃子？

    思路分析：逆推
    1. day = 10 时 有 1个桃子
    2. day = 9 时 有 （day10 + 1） * 2 = 4
    3. day = 8 时 有 （day9 + 1） * 2 = 10
    4. 规律就是 前一天的桃子 = (后一天的桃子 + 1) * 2
    5. 递归
    */
    public int monkeyEatingPeach(int day) {
        if(10 < day){
            System.out.println("超过10天没桃吃");
            return -1;
        }
        if(1 > day){
            System.out.println("天数不能小于1");
            return -1;
        }
        if(10 == day){
            return 1;
        } else {
            return (monkeyEatingPeach(day+1) + 1) * 2;
        }
    }
}
