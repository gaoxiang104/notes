package pers.gx.p4;

public class MethodExercise01 {
    public static void main (String[] args) {
        Aa aa = new Aa();
        System.out.println("3 is ood ? ");
        System.out.println(aa.isOdd(3));

        System.out.println(" -------- ");
        aa.print(4,5,"$");
    }
}

class Aa {
    // 编写类Aa 新方法：判断一个数是奇数odd还是偶数，返回boolean
    public boolean isOdd (int n) {
        return  n % 2 != 0;
    }

    // 根据行，列，字符打印 对应行数和列数的字符，比如：行：4，列：4，字符# ， 则打印相应的效果
    public void print(int row, int columns, String str){
        for(int i = 0; i <= row; i++) {
            for(int j = 0; j <= columns; j++) {
                System.out.print(str);
            }
            System.out.print("\n");
        }
    }

}