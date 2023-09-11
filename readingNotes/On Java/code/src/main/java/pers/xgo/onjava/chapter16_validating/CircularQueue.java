package pers.xgo.onjava.chapter16_validating;

// 循环队列
// 契约式设计（DbC）的演示

import java.util.Arrays;

class CircularQueueException extends RuntimeException {
    public CircularQueueException(String message) {
        super(message);
    }
}

public class CircularQueue  {
    private Object[] data;

    private int in = 0, // 下一个可用的存储空间
            out = 0; // 下一个可以获取的对象

    private boolean wrapped = false; // 是否已经回到了循环队列的开头？

    public CircularQueue(int size) {
        data = new Object[size];
        // 构建后必须为真
        assert invariant();
    }

    public boolean empty() {
        return !wrapped && in == out;
    }

    public boolean full() { // 队列是否已满
        return wrapped && in == out;
    }

    public boolean isWrapped() {
        return wrapped;
    }

    public void put(Object item) {
        precondition(item != null, "put() null item");
        precondition(!full(), "put() into full CircularQueue");
        assert invariant();
        data[in++] = item;
        if (in >= data.length) {
            in = 0;
            wrapped = true;
        }
        assert invariant();
    }

    public Object get() {
        precondition(!empty(), "get() from empty CircularQueue");
        assert invariant();
        Object returnVal = data[out];
        data[out] = null;
        out++;
        if (out >= data.length) {
            out = 0;
            wrapped = false;
        }
        assert postcondition(returnVal != null, "Null item in CircularQueue");
        assert invariant();
        return returnVal;
    }

    // 契约设计的相关方法
    private static void precondition(boolean cond, String msg) { // 先决条件
        if (!cond) throw new CircularQueueException(msg);
    }

    private static boolean postcondition(boolean cond, String msg) { // 后条件
        if (!cond) throw new CircularQueueException(msg);
        return true;
    }

    private boolean invariant() { // 不变的
        // 保证在保存了对象的 data 区域不会有空值：
        for (int i = out; i != in; i = (i + 1) % data.length) {
            if (data[i] == null) {
                throw new CircularQueueException("null in CircularQueue");
            }
        }
        // 保证在保存了对象的 data 区域之外只会有空值：
        if (full()) return true;
        for (int i = in; i != out; i = (i + 1) % data.length) {
            if (data[i] != null) {
                throw new CircularQueueException("non-null outside of CircularQueue range" + dump());
            }
        }
        return true;
    }

    public String dump() {
        return "in = " + in +
                ", out = " + out +
                ", full() = " + full() +
                ", CircularQueue = " + Arrays.asList(data);
    }
}

