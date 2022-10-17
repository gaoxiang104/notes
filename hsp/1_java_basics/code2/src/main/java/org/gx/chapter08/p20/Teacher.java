package org.gx.chapter08.p20;

public class Teacher extends Person {

    private int work_age;

    public Teacher() {
    }

    public Teacher(String name, String sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public void teach() {
        System.out.println("我承诺，我会好好教学。");
    }

    @Override
    public String play() {
        return super.play() + "爱玩象棋";
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"work_age\":\"")
                .append(work_age).append('\"');
        sb.append("\"name\":\"")
                .append(getName()).append('\"');
        sb.append("\"sex\":\"")
                .append(getSex()).append('\"');
        sb.append("\"age\":\"")
                .append(getAge()).append('\"');
        sb.append(",")
                .append(play());
        sb.append('}');
        return sb.toString();
    }
}
