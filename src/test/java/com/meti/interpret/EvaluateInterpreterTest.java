package com.meti.interpret;

import com.meti.assemble.node.DeclareNode;
import com.meti.assemble.node.IntNode;
import com.meti.interpret.evaluate.DeclareEvaluator;
import com.meti.interpret.evaluate.EvaluateInterpreter;
import com.meti.interpret.evaluate.IntEvaluator;
import com.meti.interpret.resolve.PrimitiveResolver;
import com.meti.interpret.statement.AssignStatement;
import com.meti.interpret.statement.DeclareStatement;
import com.meti.interpret.statement.GroupStatement;
import com.meti.interpret.statement.IntStatement;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EvaluateInterpreterTest {

    @Test
    void interpret() {
        var interpreter = new EvaluateInterpreter(Set.of(new DeclareEvaluator(), new IntEvaluator()), singleton(new PrimitiveResolver()));
        var statement = interpreter.interpret(new DeclareNode(true, "x", new IntNode(10)));
        var children = ((GroupStatement) statement).children();
        assertEquals(2, children.size());

        var declare = (DeclareStatement) children.get(0);
        assertTrue(declare.mutable());
        assertEquals(Primitive.INT, declare.variable().type());
        assertEquals("x", declare.variable().name());

        var assign = (AssignStatement) children.get(1);
        assertEquals("x", assign.variable().name());
        assertEquals(10, ((IntStatement) assign.value()).value());
    }

    @Test
    void resolve() {
        var interpreter = new EvaluateInterpreter(emptySet(), singleton(new PrimitiveResolver()));
        var type = interpreter.resolve(new IntStatement(10));
        assertEquals(Primitive.INT, type);
    }
}