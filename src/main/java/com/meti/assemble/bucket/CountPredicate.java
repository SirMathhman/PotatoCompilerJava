package com.meti.assemble.bucket;

import java.util.function.Predicate;

public class CountPredicate<T> implements ResettablePredicate<T> {
    private final int count;
    private int counter = 0;

    private CountPredicate(int count) {
        this.count = count;
    }

    public static <T> Predicate<T> count(int count) {
        return new CountPredicate<>(count);
    }

    @Override
    public void reset() {
        counter = 0;
    }

    @Override
    public boolean test(T token) {
        var hasSpace = counter != count;
        if (hasSpace) counter++;
        return hasSpace;
    }
}
