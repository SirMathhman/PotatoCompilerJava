package com.meti.lex.token;

import com.meti.lex.StringLexerInput;
import com.meti.lex.tokenizer.BracketTokenizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketTokenizerTest {

    @Test
    void match() {
        var tokenizer = new BracketTokenizer();
        var token = tokenizer.match(new StringLexerInput("{"));
        assertTrue(token.orElseThrow().valueAs(Boolean.class));
    }
}