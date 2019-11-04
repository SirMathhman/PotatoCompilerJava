package com.meti.assemble;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyNodeTest {

    @Test
    void children() {
        var node = new EmptyNode();
        assertTrue(node.children().isEmpty());
    }
}