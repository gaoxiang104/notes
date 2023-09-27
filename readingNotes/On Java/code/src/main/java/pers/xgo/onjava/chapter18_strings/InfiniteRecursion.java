package pers.xgo.onjava.chapter18_strings;

import java.util.stream.Stream;

public class InfiniteRecursion {
    @Override
    public String toString() {
//        return "InfiniteRecursion: " + this + "\n"; //! error
        return "InfiniteRecursion: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        Stream.generate(InfiniteRecursion::new)
                .limit(10)
                .forEach(System.out::println);
    }
}
/* ERROR:
Exception in thread "main" java.lang.StackOverflowError
 */