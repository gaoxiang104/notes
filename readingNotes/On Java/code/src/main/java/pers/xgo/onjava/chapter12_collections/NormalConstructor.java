package pers.xgo.onjava.chapter12_collections;

// {NewFeature} 从 JDK 16 开始

record Value(int x) {
    Value(int x) {
        this.x = x;
    }
}