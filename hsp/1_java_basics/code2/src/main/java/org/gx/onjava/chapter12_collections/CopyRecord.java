package org.gx.onjava.chapter12_collections;

// {NewFeature} 从 JDK 16 开始

record R(int a, double b, char c) {
}

class CopyRecord {
    public static void main(String[] args) {
        var r1 = new R(11, 2.2, 'z');
        var r2 = new R(r1.a(), r1.b(), r1.c());
        System.out.println(r1.equals(r2));
        var r3 = new R(11, 2.2, 'z'); // r3属性值与r1相同
        System.out.println(r1.equals(r3));

    }
}
/* OUTPUT:
true
true
 */