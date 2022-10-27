package org.gx.chapter10.p03;

public class HomeWork02 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        System.out.println(new Frock());
        System.out.println(new Frock());
        System.out.println(new Frock());
    }
}

class Frock { // 工作服
    private static int currentNum = 100000;

    private int serialNumber;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum() {
        return currentNum += 100;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"serialNumber\":")
                .append(serialNumber);
        sb.append('}');
        return sb.toString();
    }
}
