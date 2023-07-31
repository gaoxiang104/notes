package pers.xgo.onjava.chapter10_interfaces;

// 操作接口
public interface Operation {
    void execute();

    static void runOps(Operation... ops) {
        for (Operation op : ops) {
            op.execute();
        }
    }

    static void show(String msg) {
        System.out.println(msg);
    }
}
