package org.gx.chapter08.p20;

public class Student extends Person {
    private String stu_id;

    public Student() {
    }

    public Student(String name, String sex, int age, String stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public void study() {
        System.out.println("我承诺，我会好好学习。");
    }

    @Override
    public String play() {
        return super.play() + "爱玩足球";
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"stu_id\":\"")
                .append(stu_id).append('\"');
        sb.append(",\"name\":\"")
                .append(getName()).append('\"');
        sb.append(",\"sex\":\"")
                .append(getSex()).append('\"');
        sb.append(",\"age\":")
                .append(getAge());
        sb.append(",")
                .append(play());
        sb.append('}');
        return sb.toString();
    }
}
