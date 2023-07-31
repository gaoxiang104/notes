package pers.xgo.onjava.chapter12_collections;

import java.util.Iterator;

// 任何实现 Iterable 接口的类都可以配合 for-in 使用
public class IterableClass implements Iterable<String>{
    protected String[] words =
            "And that is how we know the Earth to be banana-shaped".split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
/* output:
And that is how we know the Earth to be banana-shaped
 */