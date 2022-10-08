package pers.gx.homework;

/**
 * 4，编写类A03，实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
 */
public class Homework04 {
    public static void main(String[] args) {
        A03 a03 = new A03();

        int[] o = new int[]{1,2,3,4,5};
        System.out.println("o : ");
        a03.showArr(o);

        int[] n = a03.copyArr(o);
        System.out.println("n : ");
        a03.showArr(n);
    }
}

class A03 {

    public int[] copyArr(int[] list) {
        if(list.length <= 0){
            throw new RuntimeException("参数错误");
        }
        int[] result = new int[list.length];
        for(int i = 0; i < list.length ;i++) {
            result[i] = list[i];
        }
        return result;
    }

    public void showArr(int[] list){
        for(int i = 0; i < list.length ;i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
   
}