package com.meti.lexeme;

import com.meti.lexeme.match.Match;

import java.util.List;

public interface Lexer {
    List<? extends Match<?>> parse(String value);
}
