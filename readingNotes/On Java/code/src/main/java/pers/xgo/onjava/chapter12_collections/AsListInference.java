package pers.xgo.onjava.chapter12_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {
} // 雪

class Powder extends Snow {
} // 粉

class Light extends Powder {
}

class Heavy extends Powder {
} // 重

class Crusty extends Snow {
} // 易怒

class Slush extends Snow {
} // 行贿

public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        // snow1.add(new Heavy()); // 异常
        List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());
        // snow2.add(new Slush()); // 异常

        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,new Light(),new Heavy(),new Powder());
        snow3.add(new Crusty());

        // 以显式类型参数说明作为提示
        List<Snow> snow4 = Arrays.<Snow>asList(new Light(),new Heavy(),new Slush());
        // snow4.add(new Powder()); // 异常
    }
}
