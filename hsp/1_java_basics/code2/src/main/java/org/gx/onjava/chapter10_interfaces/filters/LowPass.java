package org.gx.onjava.chapter10_interfaces.filters;

public class LowPass extends Filter{ // 低通
    double cutoff; // 中止;切断;

    public LowPass(double cutoff) {
        this.cutoff = cutoff;
    }

    @Override
    public Waveform process(Waveform input) { // 哑处理（dummy processing）
        return input;
    }
}
