package pers.xgo.onjava.chapter12_collections;

// {NewFeature} 从 JDK 16 开始
record Point(int x , int y) {
    void assertPositive(int val){ // 断言为正
        if(val < 0){
            throw new IllegalArgumentException("negative");
        }
    }

    Point { // 紧凑：没有参数列表
        assertPositive(x);
        assertPositive(y);
    }
}
