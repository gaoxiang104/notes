package pers.xgo.onjava.chapter10_interfaces;

sealed interface II permits JJ {}

final class JJ implements II {}

class Something {}

public class CheckedDowncast {
    public void f(){
        II i = new JJ();
        JJ j = (JJ)i;
        // Something s = (Something) i;
        // error: incompatible types: II cannot be converted to Something
    }
}
