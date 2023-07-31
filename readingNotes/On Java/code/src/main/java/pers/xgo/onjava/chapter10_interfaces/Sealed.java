package pers.xgo.onjava.chapter10_interfaces;

sealed class Base permits D1,D2 {}

final class D1 extends Base {}
final class D2 extends Base {}
// 非法
// final class D3 extends Base {}

public class Sealed {
}
