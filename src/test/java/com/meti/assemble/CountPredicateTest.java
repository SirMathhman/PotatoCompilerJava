package com.meti.assemble;

import org.junit.jupiter.api.Test;

import static com.meti.assemble.bucket.CountPredicate.*;
import static org.junit.jupiter.api.Assertions.*;

class CountPredicateTest {

    @Test
    void test1() {
        var predicate = count(3);
        assertTrue(predicate.test(0));
        assertTrue(predicate.test(1));
        assertTrue(predicate.test(2));
        assertFalse(predicate.test(3));
    }
}