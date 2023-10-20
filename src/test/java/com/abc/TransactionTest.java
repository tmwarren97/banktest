package com.abc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {
    private static final double DOUBLE_DELTA = 1e-15;
    @Test
    public void transaction() {
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);
        assertEquals(5, t.getAmount(), DOUBLE_DELTA);
        assertNotNull(t.getTransactionDate());
    }
}
