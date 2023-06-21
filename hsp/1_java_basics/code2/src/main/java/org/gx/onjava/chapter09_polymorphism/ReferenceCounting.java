package org.gx.onjava.chapter09_polymorphism;

// 清理共享的对象
class Shared { // 共享
    private int refcount = 0; // 参考计数
    private static long counter = 0;
    private final long id = counter++;

    Shared() {
        System.out.println("Creating " + this);
    }

    public void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }
}
class Composing { // 合成
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;
    Composing(Shared shared){
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }
    protected void dispose(){
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {
          new Composing(shared),
          new Composing(shared),
          new Composing(shared),
          new Composing(shared),
          new Composing(shared),
        };
        for (Composing c : composing) {
            c.dispose();
        }
    }
}
/* OUTPUT
Creating Shared 0
Creating Composing 0
Creating Composing 1
Creating Composing 2
Creating Composing 3
Creating Composing 4
disposing Composing 0
disposing Composing 1
disposing Composing 2
disposing Composing 3
disposing Composing 4
Disposing Shared 0
 */