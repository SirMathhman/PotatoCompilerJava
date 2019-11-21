package com.meti.assemble;

import com.meti.assemble.bucket.TypePredicate;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.TokenType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TypePredicateTest {
    @Test
    void anyType() {
        var predicate = TypePredicate.any();
        assertTrue(Arrays.stream(TokenType.values())
                .map((Function<TokenType, InlineToken<?>>) InlineToken::new)
                .allMatch(predicate));
    }

    @Test
    void type() {
        var predicate = TypePredicate.type(TokenType.CONTENT);
        assertTrue(predicate.test(new InlineToken<>(TokenType.CONTENT)));
        assertFalse(predicate.test(new InlineToken<>(TokenType.DECLARE)));
    }
}