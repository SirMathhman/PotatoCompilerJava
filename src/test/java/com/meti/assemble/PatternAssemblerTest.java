package com.meti.assemble;

import com.meti.assemble.node.DeclareNode;
import com.meti.assemble.node.IntNode;
import com.meti.assemble.pattern.DeclarePattern;
import com.meti.assemble.pattern.IntPattern;
import com.meti.assemble.pattern.PatternAssembler;
import com.meti.lex.StringLexerInput;
import com.meti.lex.token.*;
import com.meti.lex.tokenizer.ContentTokenizer;
import com.meti.lex.tokenizer.DeclareTokenizer;
import com.meti.lex.tokenizer.IntegerTokenizer;
import com.meti.lex.tokenizer.OperatorTokenizer;
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
        var assembler = new PatternAssembler(new DeclarePattern(), new IntPattern());
        var node = assembler.assemble(tokens.list());
        assertTrue(node instanceof DeclareNode);
        var declaration = (DeclareNode) node;
        assertTrue(declaration.mutable());
        assertEquals("x", declaration.name());
        var value = declaration.value();
        assertTrue(value.isPresent());
        assertTrue(value.get() instanceof IntNode);
        assertEquals(10, ((IntNode) value.get()).value());
    }
}