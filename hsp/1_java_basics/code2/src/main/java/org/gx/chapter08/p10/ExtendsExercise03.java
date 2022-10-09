package org.gx.chapter08.p10;

/*
案例3 ExtendsExercise03.java
编写Computer类，包含CPU、内存、硬盘等属性，getDetails方法用于返回
Computer的详细信息
编写PC子类，继承Computer类，添加特有属性【品牌brand】
编写NotePad子类，继承Computer类，添加特有属性【演示color)
编写Test类，在main方法中创建PC和NotePad对象，分别给对象中特有的属性赋值，
以及从Computer类继承的属性赋值，并使用方法并打印输出信息。
 */
public class ExtendsExercise03 {
    public static void main(String[] args) {
        PC pc = new PC("inter i5", "6G", "1T", "联想");
        pc.getDetails();
        NotePad notePad = new NotePad("AMD R7", "16G", "512G", "白色");
        notePad.getDetails();
    }
}

class Computer {
    private String cpu;
    private String memory;
    private String hardDisk;

    public Computer() {
    }

    public Computer(String cpu, String memory, String hardDisk) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDisk = hardDisk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void getDetails() {
        System.out.print("cup : " + cpu + ", memory : " + memory + ", hardDisk : " + hardDisk);
    }
}

class PC extends Computer {
    private String brand;

    public PC() {

    }

    public PC(String cpu, String memory, String hardDisk, String brand) {
        super(cpu, memory, hardDisk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println(", brand : " + brand);
    }
}

class NotePad extends Computer {
    private String color;

    public NotePad() {
    }

    public NotePad(String cpu, String memory, String hardDisk, String color) {
        super(cpu, memory, hardDisk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println(", color : " + color);
    }
}
