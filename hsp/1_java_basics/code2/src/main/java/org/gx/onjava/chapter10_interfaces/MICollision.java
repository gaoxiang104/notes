package org.gx.onjava.chapter10_interfaces;

import javax.crypto.spec.PSource;

interface Bob1 {
    default void bob() {
        System.out.println("bob");
    }
}

interface Bob2 {
    default void bob() {
        System.out.println("bob");
    }
}
//class Bob implements Bob1, Bob2{}
// error : Bob inherits unrelated defaults for bob() from Bob1, Bob2

interface Sam1 {
    default void sam() {
        System.out.println("Sam1::sam");
    }
}

interface Sam2 {
    default void sam(int i) {
        System.out.println(i * 2);
    }
}

class Sam implements Sam1, Sam2 {
}

interface Max1 {
    default void max() {
        System.out.println("Max1::max");
    }
}

interface Max2 {
    default int max() {
        return 47;
    }
}
//class Max implements Max1,Max2{}
// error: 'max()' in 'Max1' clashes with 'max()' in 'Max2'; attempting to use incompatible return type
// 试图使用不兼容的返回类型

interface Jim1{
    default void jim(){
        System.out.println("Jim1::jim");
    }
}
interface Jim2{
    default void jim(){
        System.out.println("Jim2::jim");
    }
}
class Jim implements Jim1,Jim2{
    @Override
    public void jim() {
        Jim2.super.jim(); // 使用super关键字来选择一个基类实现
    }
}

public class MICollision {
    public static void main(String[] args) {
        Jim jim = new Jim();
        jim.jim();
    }
}
