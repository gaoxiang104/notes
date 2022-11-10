package org.gx.chapter13.p02;

public class StringBufferDemo01 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        sb.append(" Word !"); // 增
        System.out.println(sb);
        sb.delete(0, 2); // 删
        System.out.println(sb);
        sb.replace(0, 2, "$$$"); // 改
        System.out.println(sb);
        sb.insert(0, "Hello ,"); // 插入
        System.out.println(sb);
        System.out.println(sb.length()); // 长度

        String str = null;
        StringBuffer sb1 = new StringBuffer();
        sb1.append(str);
        System.out.println(sb1.length()); // 4
        System.out.println(sb1); // null

        StringBuffer sb2 = new StringBuffer(str); // 空指针，因为 StringBuffer构造器中，使用类 str.length()
        System.out.println(sb2);
    }
}
