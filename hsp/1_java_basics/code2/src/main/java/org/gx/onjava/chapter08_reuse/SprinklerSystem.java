package org.gx.onjava.chapter08_reuse;

// 使用组合来复用代码

class WaterSource { // 水源
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed"; // 已建造
    }

    @Override
    public String toString() {
        return s;
    }
}

public class SprinklerSystem { // 自动喷水灭火系统
    private String value1, value2, value3, value4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"value1\":\"")
                .append(value1).append('\"');
        sb.append(",\"value2\":\"")
                .append(value2).append('\"');
        sb.append(",\"value3\":\"")
                .append(value3).append('\"');
        sb.append(",\"value4\":\"")
                .append(value4).append('\"');
        sb.append(",\"source\":")
                .append(source);
        sb.append(",\"i\":")
                .append(i);
        sb.append(",\"f\":")
                .append(f);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }
}
