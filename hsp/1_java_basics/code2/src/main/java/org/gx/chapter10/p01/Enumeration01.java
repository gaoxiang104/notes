package org.gx.chapter10.p01;

public class Enumeration01 {
    public static void main(String[] args) {
        Season spring = new Season("春天", "生长");
        Season summer = new Season("夏天", "炎热");
        Season fall = new Season("秋天", "气爽");
        Season winter = new Season("冬天", "飘雪");
        // 因为对于季节而言，他的对象（具体值），是固定的四个，不会有更多
        // 按照当前设计类的思路，不能体现季节是固定的四个对象
        // 因此这样的设计不好 ==》 枚举类[枚：一个一个； 举：列举；]

        System.out.println(SeasonV2.SPRING);
    }
}

/**
 * 季节：第一版 <br/>
 * 因为对于季节而言，他的对象（具体值），是固定的四个，不会有更多 <br/>
 * 按照当前设计类的思路，不能体现季节是固定的四个对象 <br/>
 */
class Season {
    private String name;
    private String desc;

    public Season() {
    }

    public Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

/**
 * 季节：第二版 <br/>
 * 步骤：
 * 1. 构造器私有
 * 2. 只提供geter方法，因为只能读，不能改
 */
class SeasonV2 {
    private String name;
    private String desc;

    public static final SeasonV2 SPRING = new SeasonV2("春天", "生长");
    public static final SeasonV2 SUMMER = new SeasonV2("夏天", "炎热");
    public static final SeasonV2 FALL = new SeasonV2("秋天", "气爽");
    public static final SeasonV2 WINTER = new SeasonV2("冬天", "飘雪");

    private SeasonV2(String name, String desc) {
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
        sb.append("\"name\":\"").append(name).append('\"');
        sb.append(",\"desc\":\"").append(desc).append('\"');
        sb.append('}');
        return sb.toString();
    }
}