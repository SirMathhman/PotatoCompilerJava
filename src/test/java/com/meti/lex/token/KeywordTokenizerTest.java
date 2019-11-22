package com.meti.lex.token;

import com.meti.lex.StringLexerInput;
import com.meti.lex.tokenizer.KeywordTokenizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeywordTokenizerTest {

    @Test
    void match() {
        var tokenizer = new KeywordTokenizer();
        var result = tokenizer.match(new StringLexerInput("if")
                .extend());
        var token = result.orElseThrow();
        assertEquals(Keyword.IF, token.value());
    }
}