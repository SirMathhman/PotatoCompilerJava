package com.meti.interpret;

import com.meti.interpret.resolve.TypedResolver;
import com.meti.interpret.statement.IntStatement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypedResolverTest {

    @Test
    void canResolve() {
        assertTrue(new TypedResolver().canResolve(new IntStatement(10)));
    }

    @Test
    void resolve() {
        assertEquals(Primitive.INT, new TypedResolver().resolve(new IntStatement(10), ));
    }
}