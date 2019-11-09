package com.meti.compile;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class SimpleCompilerTest {
    @Test
    void contains() {
        var list = singletonList("some");
        var function = mock(Function.class);
        var map = Map.of(list, function);
        var compiler = new SimpleCompiler(map);
        assertTrue(compiler.contains("some"));
    }

    @Test
    void putValid() {
        var map = new HashMap<List<String>, Function>();
        var compiler = new SimpleCompiler(map);
        var expected = mock(Function.class);
        compiler.put("some", expected);
        assertTrue(compiler.contains("some"));
    }

    @Test
    void putInvalid() {
        var compiler = new SimpleCompiler();
        var mockedFunction = mock(Function.class);
        compiler.put("some", mockedFunction);
        assertThrows(IllegalArgumentException.class,
                () -> compiler.put("some", mockedFunction));
    }
}