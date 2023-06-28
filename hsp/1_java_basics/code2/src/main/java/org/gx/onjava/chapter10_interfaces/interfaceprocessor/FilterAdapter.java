package org.gx.onjava.chapter10_interfaces.interfaceprocessor;

import org.gx.onjava.chapter10_interfaces.filters.Filter;
import org.gx.onjava.chapter10_interfaces.filters.Waveform;

public class FilterAdapter implements Processor {
    Filter filter;

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }
}
