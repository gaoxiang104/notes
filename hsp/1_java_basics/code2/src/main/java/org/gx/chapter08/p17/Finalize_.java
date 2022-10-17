package org.gx.chapter08.p17;

public class Finalize_ {
    String name;

    public Finalize_(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Finalize_ f = new Finalize_("1");
        new Finalize_("2");
        new Finalize_("3");
        new Finalize_("4");
        System.gc();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize_.finalize() : " + name);
    }
}
