package pers.xgo.onjava.chapter12_collections;

import java.util.*;

// 添加几个适配器方法
public class MultiIterableClass extends IterableClass {
    public Iterable<String> reversed(){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    private int current = words.length;
                    @Override
                    public boolean hasNext() {
                        return current > 0;
                    }

                    @Override
                    public String next() {
                        return words[--current];
                    }
                };
            }
        };
    }

    public Iterable<String> randomized(){
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<>(Arrays.asList(words));
                Collections.shuffle(shuffled,new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mic = new MultiIterableClass();
        for (String s : mic) {
            System.out.print(s + " ");
        }
        System.out.println();

        for (String s : mic.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();


        for (String s : mic.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
