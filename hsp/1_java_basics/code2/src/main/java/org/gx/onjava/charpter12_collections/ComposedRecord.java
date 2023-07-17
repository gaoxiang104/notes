package org.gx.onjava.charpter12_collections;
// {NewFeature} 从 JDK 16 开始

record Company (Employee[] e) {}

// class Conglomerate extends Company {}
// 错误：不能继承final的Company
