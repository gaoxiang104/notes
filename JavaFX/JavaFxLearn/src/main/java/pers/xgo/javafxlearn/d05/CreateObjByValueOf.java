package pers.xgo.javafxlearn.d05;

// 通过 valueOf() 方法创建对象
public class CreateObjByValueOf {

    public static CreateObjByValueOf valueOf(String value) {
        return new CreateObjByValueOf(value);
    }

    private String value;

    public CreateObjByValueOf(String value) {
        this.value = value;
    }
}
