package com.meti;

import java.util.List;

interface Lexer {
    List<? extends Token> parse(String value);
}
