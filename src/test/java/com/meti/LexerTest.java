package com.meti;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class LexerTest {
    private final Lexer lexer = new SequentialLexer(List.of(new OddBuilder(), new EvenBuilder()));

    @Test
    void parse() {
        List<? extends Token> tokens = lexer.parse("563");
        List<Class<? extends Token>> classes = tokens.stream()
                .map(Token::getClass)
                .collect(Collectors.toList());
        assertIterableEquals(List.of(OddToken.class, EvenToken.class, OddToken.class), classes);
    }

    private static final class OddBuilder implements TokenBuilder {
        @Override
        public Optional<Token> build(String subValue) {
            try {
                int value = Integer.parseInt(subValue);
                if (value % 2 == 1) return Optional.of(new OddToken());
                else return Optional.empty();
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }
    }

    private static final class EvenBuilder implements TokenBuilder {
        @Override
        public Optional<Token> build(String subValue) {
            try {
                int value = Integer.parseInt(subValue);
                if (value % 2 == 0) return Optional.of(new EvenToken());
                else return Optional.empty();
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }
    }

    private static final class OddToken implements Token {
    }

    private static final class EvenToken implements Token {

    }
}
