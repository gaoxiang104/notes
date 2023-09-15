package pers.xgo.onjava.chapter16_validating;
// 直接返回传入的参数
public class Inverter1 implements StringInverter{
    @Override
    public String inverter(String str) {
        return str;
    }
}
