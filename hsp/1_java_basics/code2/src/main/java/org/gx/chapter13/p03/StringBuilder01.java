package org.gx.chapter13.p03;

public class StringBuilder01 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("sb");
        sb.append("hello");
        sb.insert(0,"01,");
    }
}
