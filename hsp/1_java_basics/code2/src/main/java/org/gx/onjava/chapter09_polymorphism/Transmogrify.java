package org.gx.onjava.chapter09_polymorphism;

// 通过组合动态的改变对象的行为（状态设计模式）

class Actor { // 演员
    public void act() {
    }
}

class HappyActor extends Actor { // 喜剧演员
    @Override
    public void act() {
        System.out.println("HappyActor");
    }
}

class SadActor extends Actor { // 悲剧演员

    @Override
    public void act() {
        System.out.println("SadActor");
    }
}

class Stage { // 步骤 / 状态
    private Actor actor = new HappyActor();

    public void change() {
        actor = new SadActor();
    }

    public void performPlay() { // 开始表演
        actor.act();
    }
}

public class Transmogrify {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.change();
        stage.performPlay();
    }
}
/* OUTPUT:
HappyActor
SadActor
 */