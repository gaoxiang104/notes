package pers.xgo.onjava.chapter12_collections;

// {NewFeature} 从 JDK 16 开始
record NestedLocalRecords(int i) {
    record Nested(String s) {
    }

    void method() {
        record Local(String s) {
        }
    }
}
