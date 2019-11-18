package com.meti.assemble;

import com.meti.token.Token;

import java.util.function.Predicate;

class CountPredicate<T> implements Predicate<T> {
    private final int count;
    private int counter = 0;

    private CountPredicate(int count) {
        this.count = count;
    }

    static CountPredicate<Token<?>> count(int count) {
        return new CountPredicate<>(count);
    }

    @Override
    public boolean test(T token) {
        var hasSpace = counter != count;
        if (hasSpace) counter++;
        return hasSpace;
    }
}
