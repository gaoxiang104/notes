package pers.xgo.onjava.chapter14_streams;

import java.util.stream.Stream;

public class Bubbles {
    public static void main(String[] args) {
        record Bubble(int i){
            private static int count = 0;
            public static Bubble bubbler(){
                return new Bubble(count++);
            }
        }

        Stream.generate(Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}
/* OUTPUT :
Bubble[i=0]
Bubble[i=1]
Bubble[i=2]
Bubble[i=3]
Bubble[i=4]
 */