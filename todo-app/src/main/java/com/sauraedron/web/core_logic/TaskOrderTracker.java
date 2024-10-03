package com.sauraedron.web.core_logic;

import java.math.BigDecimal;

/**
 * Generates Tasks next order.
 */
public class TaskOrderTracker {
    static BigDecimal seed = BigDecimal.ONE;
    private TaskOrderTracker() {

    }

    public static synchronized BigDecimal next() {
        seed = seed.add(BigDecimal.ONE);
        return seed;
    }
}
