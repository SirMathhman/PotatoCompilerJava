package com.meti.assemble.pattern;

import com.meti.assemble.node.BlockNode;
import com.meti.assemble.node.DeclareNode;
import com.meti.lex.StringLexerInput;
import com.meti.lex.token.*;
import com.meti.lex.tokenizer.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockPatternTest {
    private Binding<Integer> depth = new Binding<>(0);

    @Test
    void collect() {
        var lexer = new TokenLexer(
                new BracketTokenizer(depth),
                new DeclareTokenizer(),
                new OperatorTokenizer(),
                new IntegerTokenizer(),
                new SplitTokenizer(depth),
                new ContentTokenizer()
        );
        var assembler = new PatternAssembler(
                new BlockPattern(new Binding<>(0)),
                new DeclarePattern(),
                new OperatorPattern(),
                new IntPattern(),
                new ContentPattern()
        );
        var tokens = lexer.lexise(new StringLexerInput("{var x = 10;var y = x;}"));
        var node = assembler.assemble(tokens.list());
        var block = (BlockNode) node;
        var children = block.nodes();
        assertEquals(2, children.size());
        assertEquals(DeclareNode.class, children.get(0).getClass());
        assertEquals(DeclareNode.class, children.get(1).getClass());
    }
}