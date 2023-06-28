package org.gx.onjava.chapter10_interfaces.filters;

public class HighPass extends Filter{ // 高通
    double cutoff; // 中止;切断;

    public HighPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) {
        return input;
    }
}
