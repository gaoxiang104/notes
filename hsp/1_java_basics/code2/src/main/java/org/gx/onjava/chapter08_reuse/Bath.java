package org.gx.onjava.chapter08_reuse;
// 使用组合进行构造器初始化

class Soap {
    private String s;

    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}

public class Bath {
    private String // 在定义时初始化
            s1 = "Happy",
            s2 = "Happy",
            s3, s4;

    private Soap castile;
    private int i;
    private float toy;

    { // 实例初始化
        i = 47;
    }

    public Bath() {
        System.out.println("Inside Bath()");
        s3 = "Joy";
        toy = 3.14f;
        castile = new Soap();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"s1\":\"")
                .append(s1).append('\"');
        sb.append(",\"s2\":\"")
                .append(s2).append('\"');
        sb.append(",\"s3\":\"")
                .append(s3).append('\"');
        sb.append(",\"s4\":\"")
                .append(s4).append('\"');
        sb.append(",\"castile\":")
                .append(castile);
        sb.append(",\"i\":")
                .append(i);
        sb.append(",\"toy\":")
                .append(toy);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Bath b= new Bath();
        System.out.println(b);
    }
}
