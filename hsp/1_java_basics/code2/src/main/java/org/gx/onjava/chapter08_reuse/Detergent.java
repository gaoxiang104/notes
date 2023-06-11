package org.gx.onjava.chapter08_reuse;
// 继承的语法与属性

class Cleanser{ // 清洁剂
    private String s = "Cleanser";
    public void append(String a){
        s += a;
    }
    public void dilute(){ // 稀释
        append(" dilute()");
    }
    public void apply(){ // 使用，涂抹
        append(" apply()");
    }
    public void scrub(){ // 刷洗
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

public class Detergent extends Cleanser{ // 洗涤剂
    // 修改方法

    @Override
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // 调用基类版本
    }

    public void foam(){ // 起泡沫
        append(" foam()");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class");
        Cleanser.main(args );
    }
}
