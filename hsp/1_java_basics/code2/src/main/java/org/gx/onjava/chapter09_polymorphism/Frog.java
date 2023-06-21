package org.gx.onjava.chapter09_polymorphism;

class Characteristic { // 特征
    private String s;

    public Characteristic(String s) {
        this.s = s;
        System.out.println("Create Characteristic " + s);
    }

    protected void dispose() { // 处理
        System.out.println("dispose Characteristic " + s);
    }
}

class Description{ // 描述
    private String s;

    public Description(String s) {
        this.s = s;
        System.out.println("Create Description " + s);
    }

    protected void dispose() { // 处理
        System.out.println("dispose Description " + s);
    }
}

class LivingCreature { // 活体生物
    private Characteristic p = new Characteristic("is alive");
    private Description t = new Description("Basic Living Creature"); // 基本生物
    LivingCreature(){
        System.out.println("LivingCreature()");
    }
    protected void dispose() { // 处理
        System.out.println("LivingCreature dispose");
        t.dispose();
        p.dispose();
    }
}

class Animal extends LivingCreature{
    private Characteristic p = new Characteristic("has heart");
    private  Description t = new Description("Animal not Vegetable");
    Animal(){
        System.out.println("Animal()");
    }

    @Override
    protected void dispose() {
        System.out.println("Animal dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

class Amphibian extends Animal{ // 两栖动物
    private Characteristic p = new Characteristic("can live in water");
    private  Description t = new Description("Both water and land");
    Amphibian(){
        System.out.println("Amphibian()");
    }

    @Override
    protected void dispose() {
        System.out.println("Amphibian dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }
}

public class Frog extends Amphibian{ // 蛙
    private Characteristic p = new Characteristic("Croaks");
    private  Description t = new Description("Eats Bugs");
    Frog(){
        System.out.println("Frog()");
    }

    @Override
    protected void dispose() {
        System.out.println("Frog dispose");
        t.dispose();
        p.dispose();
        super.dispose();
    }

    public static void main(String[] args) {
        Frog frog = new Frog();
        System.out.println("Bye!");
        frog.dispose();
    }
}
/*
Create Characteristic is alive
Create Description Basic Living Creature
LivingCreature()
Create Characteristic has heart
Create Description Animal not Vegetable
Animal()
Create Characteristic can live in water
Create Description Both water and land
Amphibian()
Create Characteristic Croaks
Create Description Eats Bugs
Frog()
Bye!
Frog dispose
dispose Description Eats Bugs
dispose Characteristic Croaks
Amphibian dispose
dispose Description Both water and land
dispose Characteristic can live in water
Animal dispose
dispose Description Animal not Vegetable
dispose Characteristic has heart
LivingCreature dispose
dispose Description Basic Living Creature
dispose Characteristic is alive
 */