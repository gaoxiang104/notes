package org.gx.onjava.chapter13_funcational;

interface Description { // 描述
    String brief(); // 简明的
}

interface Body {
    String detailed(String head); // 详细的
}

interface Multi { // 更多
    String twoArg(String head, Double d); // 两参数
}

public class LambdaExpressions {
    static Body bod = h -> h + "No parens!"; // [1]
    static Body bod2 = (h) -> h + "More details"; // [2]
    static Description desc = () -> "Short info"; // [3]
    static Multi mult = (h, n) -> h + n; // [4]

    static Description moreLines = () -> { // [5]
        System.out.println("moreLines");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh! "));
        System.out.println(bod2.detailed("Hi! "));
        System.out.println(desc.brief());
        System.out.println(mult.twoArg("Pi! ", 3.14159));
        System.out.println(moreLines.brief());
    }
}
/* OUTPUT:
Oh! No parens!
Hi! More details
Short info
Pi! 3.14159
moreLines
from moreLines()
 */