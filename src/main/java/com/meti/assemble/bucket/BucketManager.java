package com.meti.assemble.bucket;

import com.meti.lex.token.Token;

import java.util.List;

public interface BucketManager {
    void add(Token<?> token);

    void reset();

    default void addAll(List<? extends Token<?>> tokens) {
        tokens.forEach(this::add);
    }
}
