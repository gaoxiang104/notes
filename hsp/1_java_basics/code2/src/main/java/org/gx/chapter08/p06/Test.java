package org.gx.chapter08.p06;

public class Test {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.setName("小明");
        pupil.setAge(10);
        pupil.setScore(50);
        pupil.testing();

        Graduate graduate = new Graduate();
        graduate.setName("小强");
        graduate.setAge(20);
        graduate.setScore(80);
        graduate.testing();
    }
}
