package com.meti.assemble.pattern;

import com.meti.assemble.node.VariableNode;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VariablePatternTest {

    @Test
    void collect() {
        var node = new VariablePattern()
                .form(new InlineToken<>(TokenType.CONTENT, "test"))
                .collect(null)
                .orElseThrow();
        assertTrue(node instanceof VariableNode);
        var variable = (VariableNode) node;
        var name = variable.name();
        assertEquals("test", name);
    }
}