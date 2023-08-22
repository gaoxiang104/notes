package pers.xgo.onjava.chapter15_exceptions;
// 编程访问栈轨迹信息
public class WhoCalled {
    static void f() {
        // 生成一个异常来填充栈轨迹
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {f();}
    static void h() {g();}

    public static void main(String[] args) {
        f();
        System.out.println("*******");
        g();
        System.out.println("*******");
        h();
    }
}
