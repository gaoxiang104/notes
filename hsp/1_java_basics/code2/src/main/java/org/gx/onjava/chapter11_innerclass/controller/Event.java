package org.gx.onjava.chapter11_innerclass.controller;
// 用于任何控制事件的公共方法
import java.time.Duration;
import java.time.Instant;

public abstract class Event {
    private Instant eventTime; // 瞬间

    protected final Duration delayTime; // 延迟时间

    public Event(long millisecondDelay){ // 毫秒级延迟
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start(){ // 可以重启
        eventTime = Instant.now().plus(delayTime);
    }

    // 用于判断是否准备好，要开始执行 action() 了
    public boolean ready(){
        return Instant.now().isAfter(eventTime);
    }
    public abstract void action(); // 行动
}
