package com.meti.assemble;

import com.meti.token.Token;

import java.util.List;

interface BucketManager {
    void add(Token<?> token);

    void reset();

    default void addAll(List<? extends Token<?>> tokens) {
        tokens.forEach(this::add);
    }
}
