package org.gx.onjava.charpter12_collections;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

// 所有集合类都可以配合 for-in 使用
public class ForInCollections {
    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs) {
            System.out.print("'" + s + "' ");
        }
        System.out.println();
    }
}
