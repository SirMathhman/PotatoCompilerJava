package com.meti.assemble;

import com.meti.assemble.node.DeclarationNode;
import com.meti.assemble.node.IntNode;
import com.meti.assemble.pattern.DeclarationPattern;
import com.meti.assemble.pattern.IntegerPattern;
import com.meti.assemble.pattern.PatternAssembler;
import com.meti.lex.StringLexerInput;
import com.meti.token.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PatternAssemblerTest {

    @Test
    void assemble() {
        var lexer = new TokenLexer(
                new DeclareTokenizer(),
                new OperatorTokenizer(),
                new IntegerTokenizer(),
                new ContentTokenizer()
        );
        var tokens = lexer.lexise(new StringLexerInput("var x = 10"));
        var assembler = new PatternAssembler(new DeclarationPattern(), new IntegerPattern());
        var node = assembler.assemble(tokens.list());
        assertTrue(node instanceof DeclarationNode);
        var declaration = (DeclarationNode) node;
        assertTrue(declaration.mutable());
        assertEquals("x", declaration.name());
        var value = declaration.value();
        assertTrue(value.isPresent());
        assertTrue(value.get() instanceof IntNode);
        assertEquals(10, ((IntNode) value.get()).value());
    }
}