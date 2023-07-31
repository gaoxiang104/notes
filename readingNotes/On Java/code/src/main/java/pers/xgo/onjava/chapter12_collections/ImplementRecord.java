package pers.xgo.onjava.chapter12_collections;
// {NewFeature} 从 JDK 16 开始

interface Star {
    double brightness(); // 亮度

    double density(); // 密度
}

record RedDwarf(double brightness) implements Star { // 红矮星
    @Override
    public double density() {
        return 100.0;
    }
}