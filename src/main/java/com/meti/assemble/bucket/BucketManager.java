package com.meti.assemble.bucket;

import com.meti.lex.token.Token;

import java.util.List;
import java.util.function.Predicate;

public interface BucketManager {
    boolean allPresent();

    List<? extends Token<?>> at(int index);

    <R> R at(int index, Class<R> clazz);

    void add(Token<?> token);

	void reset();

    default void addAll(List<? extends Token<?>> tokens) {
        tokens.forEach(this::add);
    }

    List<? extends List<? extends Token<?>>> split(int index, Predicate<? super Token<?>> predicate);
}
