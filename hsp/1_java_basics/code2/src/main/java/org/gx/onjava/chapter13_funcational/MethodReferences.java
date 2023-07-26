package org.gx.onjava.chapter13_funcational;

interface Callable { // [1]
    void call(String s);
}

class Describe{
    void show(String msg){ // [2]
        System.out.println(msg);
    }
}

public class MethodReferences {
    static void hello(String name){ // [3]
        System.out.println("hello, " + name);
    }
    static class Description{
        String about;

        public Description(String about) {
            this.about = about;
        }
        void help(String msg){ // [4]
            System.out.println(about + " " + msg);
        }
    }
    static class Helper {
        static void assist(String msg) { // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show; // [6]
        c.call("call()"); // [7]

        c = MethodReferences::hello; // [8]
        c.call("Bob");

        c = new Description("valuable")::help; // [9]
        c.call("information");

        c = Helper::assist; // [10]
        c.call("Help!");
    }
}
/*
call()
hello, Bob
valuable information
Help!
 */