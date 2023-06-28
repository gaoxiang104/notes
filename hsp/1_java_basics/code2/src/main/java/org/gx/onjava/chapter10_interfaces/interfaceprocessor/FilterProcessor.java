package org.gx.onjava.chapter10_interfaces.interfaceprocessor;

import org.gx.onjava.chapter10_interfaces.filters.BandPass;
import org.gx.onjava.chapter10_interfaces.filters.HighPass;
import org.gx.onjava.chapter10_interfaces.filters.LowPass;
import org.gx.onjava.chapter10_interfaces.filters.Waveform;

public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Applicator.apply(new FilterAdapter(new LowPass(1.0)), w);
        Applicator.apply(new FilterAdapter(new HighPass(2.0)), w);
        Applicator.apply(new FilterAdapter(new BandPass(3.0,4.0)), w);
    }
}
