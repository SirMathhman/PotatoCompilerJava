package com.meti.assemble.bucket;

import com.meti.lex.token.Token;

import java.util.List;

public interface Bucket {
    boolean add(Token<?> token);

    List<? extends Token<?>> content();

    default boolean present() {
        return !content().isEmpty();
    }

    default Token<?> single() {
        return content().get(0);
    }

    void empty();
}