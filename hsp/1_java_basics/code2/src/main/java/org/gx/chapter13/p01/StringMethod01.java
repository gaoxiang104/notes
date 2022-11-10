package org.gx.chapter13.p01;

public class StringMethod01 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bcd";
        System.out.println(s1.equals(s2)); // 1，equals()比较字符串值是否相等

        String s3 = "Abc";
        System.out.println(s1.equalsIgnoreCase(s3)); // 2, equalsIgnoreCase()比较字符串值是否相等，忽略大小写

        String s4 = "abcdefj";
        System.out.println(s4.length()); // 3, length()获取字符串长度

        String s5 = "abc@123.com";
        System.out.println(s5.indexOf('@')); // 4, indexOf()获取字符/字符串 在字符串对象中第一次出现的索引，索引从0开始，找不到返回-1

        String s6 = "abc@abc@123.com";
        System.out.println(s6.lastIndexOf('@')); // 5, lastIndexOf()获取字符/字符串 在字符串对象中最后一次出现的索引，索引从0开始，找不到返回-1

        String s7 = "abc12345";
        System.out.println(s7.substring(3)); // substring()截取索引3后面的字符（包含索引3）
        System.out.println(s7.substring(3, 5)); // substring()从索引3开始截取（包含索引3），到索引5的字符（不包含5），也就是 5-1 的位置

        String s8 = "AbcDef";
        System.out.println(s8.toUpperCase()); // toUpperCase() 转换成大写
        System.out.println(s8.toLowerCase()); // toLowerCase() 转换成小写

        String s9 = "abc";
        System.out.println(s9.concat("123")); // concat() 字符串拼接

        String s10 = "a_b_c_d_e";
        System.out.println(s10.replace('_', '&')); // replace(oldChar, newChar) 替换字符
        System.out.println(s10.replace("_", "#")); // replace(target, replacement) 替换字符串
        System.out.println(s10.replaceAll("_", "%")); // replace(regex, replacement) 替换字符串，使用正则，替换所有
        System.out.println(s10.replaceFirst("_", "^")); // replace(regex, replacement) 替换字符串，使用正则，替换第一个匹配到到

        String[] s = s10.split("_"); // split(regex) 分割字符串

        String s11 = "abc";
        char[] chars = s11.toCharArray(); // toCharArray() 转换成字符数组

        String s12 = "abc";
        String s13 = "abcd";
        System.out.println(s12.compareTo(s13)); // 比较两个字符串大小

        String name = "gao";
        int age = 10;
        double sal = 1888.8888;
        char gender = '男';
        String formatStr = "我到姓名是%s 年龄是%d, 性别是%c,薪资是%.2f";
        // String.format() 格式化字符串
        // 占位符
        //  1. %s 表示后面由【字符串】替换
        //  2. %d 表示后面由【整数】替换
        //  3. %2f 表示后面由【小数】替换，并且保留小数点两位，还会进行四舍五入
        //  4. %c 表示后面由【char类型】替换
        System.out.println(String.format(formatStr, name, age, gender, sal));


    }
}
