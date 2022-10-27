package org.gx.chapter10.p03;

public class HomeWork07 {
    public static void main(String[] args) {
        new Car(28.1).useAir();
        new Car(40).useAir();
        new Car(33.3).useAir();
        new Car(-1.1).useAir();
    }
}

class Car {
    private double temperature; // 温度

    private Air air = new Air();

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        void flow() {
            if (temperature >= 40) {
                System.out.println("车内温度：" + temperature + "度，空调工作：开始降温");
            } else if (temperature <= 0) {
                System.out.println("车内温度：" + temperature + "度，空调工作：开始升温");
            } else {
                System.out.println("车内温度：" + temperature + "度，温度适中，空调不工作");
            }
        }
    }

    void useAir() {
        air.flow();
    }

}