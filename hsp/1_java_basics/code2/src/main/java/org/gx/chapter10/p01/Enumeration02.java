package org.gx.chapter10.p01;

public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(SeasonEnum.SPRING);
    }
}

/**
 * 季节
 */
// enum 代替 class
enum SeasonEnum {
    // 多个常量（对象）
    SPRING("春天", "生长"),
    SUMMER("夏天", "炎热"),
    FAIL("秋天", "气爽"),
    WINTER("冬天", "飘雪");

    private String name;
    private String desc;

    SeasonEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"desc\":\"")
                .append(desc).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
