package org.gx.onjava.charpter12_collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<T> {
    private Deque<T> storage = new ArrayDeque<>();

    public void push(T v) {
        storage.push(v);
    }

    public T peek() {
        return storage.peek();
    }

    public T pop() {
        return storage.pop();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
