package org.gx.onjava.chapter11_innerclass;
// 保存一个对象序列

interface Selector { // 迭代器
    boolean end(); // 检查是否末尾

    Object current(); // 访问当前

    void next(); // 移动到下一个
}

public class Sequence { // 序列
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) { // 添加元素
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector { // 实现迭代器
        private int i = 0;
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector selector(){ // 工厂方法
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
/* OUTPUT:
0 1 2 3 4 5 6 7 8 9
 */