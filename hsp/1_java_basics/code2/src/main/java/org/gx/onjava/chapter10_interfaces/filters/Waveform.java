package org.gx.onjava.chapter10_interfaces.filters;

public class Waveform { // 波形;波形图;输出波形;波型;波形示波器
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Waveform " + id;
    }
}
