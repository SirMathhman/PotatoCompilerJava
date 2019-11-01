package com.meti.assemble;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BlockNodeTest {

    @Test
    void testEquals() {
        AssemblyNode node0 = new SimpleBlockNodeBuilder()
                .withName("test")
                .withArguments(Map.of("value", Primitive.STRING))
                .withModifiers(Collections.singleton(Modifier.SINGLE))
                .build();
        Map<String, Type> map = new HashMap<>();
        map.put("value", Primitive.STRING);
        var modifier = new HashSet<Modifier>();
        modifier.add(Modifier.SINGLE);
        AssemblyNode node1 = new SimpleBlockNodeBuilder()
                .withName("test")
                .withArguments(map)
                .withModifiers(modifier)
                .build();
        assertEquals(node0, node1);
    }
}