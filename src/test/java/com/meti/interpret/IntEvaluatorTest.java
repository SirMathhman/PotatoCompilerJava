package com.meti.interpret;

import com.meti.assemble.node.IntNode;
import com.meti.interpret.evaluate.IntEvaluator;
import com.meti.interpret.statement.IntStatement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntEvaluatorTest {

    @Test
    void canEvaluate() {
        assertTrue(new IntEvaluator().canEvaluate(new IntNode(10)));
    }

    @Test
    void evaluate() {
        var statement = new IntEvaluator().evaluate(new IntNode(10), null);
        assertEquals(10, ((IntStatement) statement).value());
    }
}