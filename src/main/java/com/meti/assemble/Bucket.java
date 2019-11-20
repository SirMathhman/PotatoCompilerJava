package com.meti.assemble;

import com.meti.token.Token;

import java.util.List;

interface Bucket {
    boolean add(Token<?> token);

    List<? extends Token<?>> content();

    default boolean present() {
        return !content().isEmpty();
    }

    default Token<?> single() {
        return content().get(0);
    }

    default void empty() {
        content().clear();
    }
}