package org.gx.onjava.charpter12_collections;

// {NewFeature} 从 JDK 16 开始
record PlusTen(int x) {
    PlusTen {
        x += 10;
    }

    // 对字段的调整只能在构造器中进行
    // 像下面这样任然是不合法的
    // void mutate() { x+=10; }
    public static void main(String[] args) {
        System.out.println(new PlusTen(10));
    }
}
