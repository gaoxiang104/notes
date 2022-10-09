package org.gx.chapter08.p08;

public class Sub extends Base{
    private String s2;
    private String s3;

    public Sub() {
    }

    public Sub(String s2) {
        this.s2 = s2;
    }

    public Sub(String s2, String s3) {
        this(s2);
        this.s3 = s3;
    }

    public Sub(String s1, String s2, String s3) {
        super(s1);
//        this(s2); // Call to 'this()' must be first statement in constructor body
        this.s3 = s3;
    }
}
