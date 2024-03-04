package pers.xgo.javafxlearn.d05;

// 通过工厂方法创建对象
public class CreateObjByFactory {
    public static CreateObjByFactory instance() {
        return new CreateObjByFactory();
    }
}
