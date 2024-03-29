package pers.xgo.onjava.chapter14_streams;

import java.util.Optional;

public class StreamOfOptionals {
    public static void main(String[] args) {
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);
        System.out.println();
        Signal.stream().limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
/* OUTPUT:
Optional[Signal(dash)]
Optional[Signal(dot)]
Optional[Signal(dash)]
Optional.empty
Optional.empty
Optional[Signal(dash)]
Optional.empty
Optional[Signal(dot)]
Optional[Signal(dash)]
Optional[Signal(dash)]

Signal(dot)
Signal(dot)
Signal(dash)
Signal(dash)
 */