package com.meti.assemble;

import com.meti.lex.StringLexerInput;
import com.meti.token.*;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PatternAssemblerTest {

    @Test
    void assemble() {
        var lexer = new TokenLexer(
                new ContentTokenizer(),
                new DeclareTokenizer(),
                new IntegerTokenizer(),
                new OperatorTokenizer()
        );
        var tokens = lexer.lexise(new StringLexerInput("var x = 10"));
        var assembler = new PatternAssembler(Collections.singleton(new DeclarationPattern()));
        var node = assembler.assemble(tokens.list());
        assertTrue(node instanceof DeclarationNode);
        var declaration = (DeclarationNode) node;
        assertTrue(declaration.mutable());
        assertEquals("x", declaration.name());
        var value = declaration.value();
        assertTrue(value instanceof IntNode);
        assertEquals(10, ((IntNode) value).value());
    }
}