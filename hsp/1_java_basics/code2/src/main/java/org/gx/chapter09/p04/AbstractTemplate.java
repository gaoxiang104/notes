package org.gx.chapter09.p04;

/**
 * 模版设计模式
 */
public class AbstractTemplate {
    public static void main(String[] args) {
        new ATask().calculateTime();
        new BTask().calculateTime();
    }
}

// 模版类
abstract class Task {

    // 计算job方法执行时间
    public void calculateTime() {
        long s = System.currentTimeMillis();
        job();
        long e = System.currentTimeMillis() - s;
        System.out.println(this.getClass().getName() + ",工作时间：" + (System.currentTimeMillis() - s) + "毫秒");
    }

    abstract void job();
}

class ATask extends Task {
    @Override
    void job() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class BTask extends Task {
    @Override
    void job() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}