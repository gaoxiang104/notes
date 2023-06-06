package org.gx.onjava.chapter06_housekeeping;

class Plumbus {
}

public class TypeInference {
    void method() {
        // 显示类型：
        String hello1 = "Hello";
        // 类型推断：
        var hello = "Hello";
        // 用户定义的类型也起作用：
        Plumbus pb1 = new Plumbus();
        var pb2 = new Plumbus();
    }

    static void staticMethod() {
        var hello = "Hello";
        var pb2 = new Plumbus();
    }
}

class NoInference { // 不能使用推断类型的场景
    String field1 = "Field initialization";
    // var field2 = "Can't do this";

    void method() {
        // var noInitializer; // No inference data
        // var aNull = null; // No inference data
    }

//    var inferReturnType(){
//        return "Can't infer return type";
//    }
}
