package com.meti.assemble;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

class GroupNodeTest {

    @Test
    void children() {
        var node = new EmptyNode();
        var group = new GroupNode(node);
        var expected = singleton(node);
        var actual = group.children();
        assertIterableEquals(expected, actual);
    }

    @Test
    void testEquals() {
        var node = new EmptyNode();
        var node0 = new GroupNode(node);
        var node1 = new GroupNode(node);
        assertEquals(node0, node1);
    }
}