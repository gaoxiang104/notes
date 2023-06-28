package org.gx.onjava.chapter10_interfaces.filters;

public class Filter { // 过滤器
    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
