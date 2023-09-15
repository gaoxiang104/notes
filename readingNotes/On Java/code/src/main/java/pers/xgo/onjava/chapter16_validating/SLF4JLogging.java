package pers.xgo.onjava.chapter16_validating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JLogging {
    private static Logger LOG = LoggerFactory.getLogger(SLF4JLogging.class);

    public static void main(String[] args) {
        LOG.info("hello logging");
    }
}
