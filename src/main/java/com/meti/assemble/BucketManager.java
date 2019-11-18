package com.meti.assemble;

import com.meti.token.Token;

import java.util.List;

interface BucketManager {
    boolean add(Token<?> token);

    void reset();

    default boolean addAll(List<? extends Token<?>> tokens) {
        return tokens.stream()
                .map(this::add)
                .reduce((bool0, bool1) -> bool0 && bool1)
                .orElse(false);
    }
}
