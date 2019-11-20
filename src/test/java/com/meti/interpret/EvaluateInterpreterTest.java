package com.meti.interpret;

import com.meti.assemble.node.DeclarationNode;
import com.meti.assemble.node.IntNode;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EvaluateInterpreterTest {

    @Test
    void interpret() {
        var interpreter = new EvaluateInterpreter(Set.of(new DeclareEvaluator(), new IntEvaluator()), singleton(new TypedResolver()));
        var statement = interpreter.interpret(new DeclarationNode(true, "x", new IntNode(10)));
        var children = ((GroupStatement) statement).children();
        assertEquals(2, children.size());

        var declare = (DeclarationStatement) children.get(0);
        assertTrue(declare.isMutable());
        assertEquals(Primitive.INT, declare.variable().type());
        assertEquals("x", declare.variable().name());

        var assign = (AssignmentStatement) children.get(1);
        assertEquals("x", assign.variable().name());
        assertEquals(10, ((IntStatement) assign.value()).value());
    }

    @Test
    void resolve() {
        var interpreter = new EvaluateInterpreter(emptySet(), singleton(new TypedResolver()));
        var type = interpreter.resolve(new IntStatement(10));
        assertEquals(Primitive.INT, type);
    }
}