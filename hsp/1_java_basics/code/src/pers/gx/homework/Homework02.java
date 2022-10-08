package pers.gx.homework;

/**
 * 2，编写类A02，定义方法find，实现查找某字符串数组中的元素，并返回索引，如果找不到，返回-1
 */
public class Homework02 {
    public static void main(String[] args) {
        String[] list = new String[]{"1.1", "2.2", "3.3", "4.4", "abc"};
        A02 a02 = new A02();
        System.out.println("find 'abc' index : " + a02.find(list,"abc"));
        System.out.println("find 'ab' index : " + a02.find(list,"ab"));
    }
}

class A02 {
    public int find(String[] list,String str) {
        if(list.length <= 0){
            throw new RuntimeException("参数list错误");
        }
        if(null == str){
            throw new RuntimeException("参数str错误");
        }
        int result = -1;
        for(int i = 0; i < list.length; i++){
            if(list[i].equals(str)){
                result = i;
                break;
            }
        }
        return result;
    }
}