package com.meti.interpret;

import com.meti.interpret.resolve.PrimitiveResolver;
import com.meti.interpret.statement.IntStatement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimitiveResolverTest {

    @Test
    void canResolve() {
        assertTrue(new PrimitiveResolver().canResolve(new IntStatement(10)));
    }

    @Test
    void resolve() {
        assertEquals(Primitive.INT, new PrimitiveResolver().resolve(new IntStatement(10), null));
    }
}