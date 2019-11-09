package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompileExceptionTest {
    @Test
    void construct() {
        var e = new CompileException("test");
        var message = e.getMessage();
        assertEquals("test", message);
    }
}