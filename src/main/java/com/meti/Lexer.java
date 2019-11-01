package com.meti;

import java.util.List;

interface Lexer {
    List<? extends Match> parse(String value);
}
