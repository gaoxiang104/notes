package pers.xgo.onjava.chapter12_collections;
// {NewFeature} 从 JDK 16 开始
record FinalFields(int i) {
    int timesTen() {
        return i * 10;
    }
    // void tryToChange(){ i++; } // 错误
    // 不能给最终变量i赋值
}
