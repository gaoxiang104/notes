package org.gx.onjava.chapter12_collections;
// "适配器方法惯用法"，提供了更多 Iterable 对象用于 for-in 语句

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class ReversibleArrayList<T> extends ArrayList<T> {
    ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private int index = size();
                    @Override
                    public boolean hasNext() {
                        return index > 0;
                    }

                    @Override
                    public T next() {
                        return get(--index);
                    }
                };
            }
        };
    }
}

public class AdapterMethodIdiom {
    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        // 通过 iterator() 获得原始的迭代器
        for (String s : ral) {
            System.out.print(s + " ");
        }
        System.out.println();
        // 使用我们选择的迭代方式
        for (String s : ral.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

/* OUTPUT:
To be or not to be
be to not or be To
 */