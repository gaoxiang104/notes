package org.gx.onjava.chapter10_interfaces;

class Heat implements Operation{
    @Override
    public void execute() {
        Operation.show("Heat");
    }
}

public class MetalWork {
    public static void main(String[] args) {
        // 必须在静态上下文中定义才能使用方法引用
        Operation twist = new Operation() {
            @Override
            public void execute() {
                System.out.println("Twist");
            }
        };

        Operation.runOps(
                new Heat(), // [1]
                new Operation() { // [2]
                    @Override
                    public void execute() {
                        Operation.show("Hammer");
                    }
                },
                twist::execute, // [3]
                () -> Operation.show("Anneal") // [4]
                );
    }
}
