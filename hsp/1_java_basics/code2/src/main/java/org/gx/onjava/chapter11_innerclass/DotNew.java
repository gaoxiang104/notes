package org.gx.onjava.chapter11_innerclass;
// 使用 .new 语法直接创建一个内部类的对象
public class DotNew {
    public class Inner {}

    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}
