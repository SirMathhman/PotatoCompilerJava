package com.meti;

import org.javatuples.Pair;

import java.util.List;
import java.util.function.Function;

public interface Lexer extends Function<CharSequence, List<Pair<Token, Object>>> {
}
