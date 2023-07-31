package pers.xgo.onjava.chapter08_reuse;
// 在子类中重载基类方法并不会隐藏基类版本

class Homer{
    char doh(char c){
        System.out.println("doh(char)");
        return 'd';
    }
    float doh(float f){
        System.out.println("doh(float)");
        return 1.0f;
    }
}

class Milhouse{
}

class Bart extends  Homer{
    void doh(Milhouse m){
        System.out.println("doh(Milhouse)");
    }
}

public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(new Milhouse());
    }
}
