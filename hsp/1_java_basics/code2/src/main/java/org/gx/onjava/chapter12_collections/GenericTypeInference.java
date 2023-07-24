package org.gx.onjava.chapter12_collections;

import java.util.ArrayList;

// {NewFeature} 从 JDK 11 开始
public class GenericTypeInference {
    void old(){
        ArrayList<Apple> apples = new ArrayList<Apple>();
    }
    void modern(){
        var apples = new ArrayList<Apple>();
    }

    void pitFall (){ // 坑
        var apples = new ArrayList<>();
        apples.add(new Apple());
        apples.get(0); // 作为普通的 Object 类型返回
    }
}
