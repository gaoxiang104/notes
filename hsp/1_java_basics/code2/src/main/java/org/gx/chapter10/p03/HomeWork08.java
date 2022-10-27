package org.gx.chapter10.p03;

public class HomeWork08 {
    public static void main(String[] args) {
        Color.RED.show();
        Color.YELLOW.show();

        Color c = Color.BLACK;

        switch (c) {
            case RED:
                System.out.println("红色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            default:
                System.out.println("没有匹配上");
                break;
        }

    }
}

interface Ioo {
    void show();
}

enum Color implements Ioo {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    BLACK(0, 0, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0);

    private int redValue;
    private int greenValue;
    private int blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    @Override
    public void show() {
        System.out.println(name() + " ： RGB(" + redValue + "," + greenValue + "," + blueValue + ")");
    }
}
