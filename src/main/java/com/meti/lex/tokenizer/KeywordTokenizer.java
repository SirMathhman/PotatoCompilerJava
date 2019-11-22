package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Keyword;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Arrays;
import java.util.Optional;

public class KeywordTokenizer implements Tokenizer {
    @Override
    public Optional<? extends Token> match(LexerInput input) {
        var value = input.compute();
        return Arrays.stream(Keyword.values())
                .filter(keyword -> keyword.value().equals(value))
                .findAny()
                .map(keyword -> new InlineToken<>(TokenType.KEYWORD, keyword));
    }
}
