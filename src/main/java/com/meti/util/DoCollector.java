package com.meti.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

public class DoCollector<T> implements PredicateCollector<T> {
    private final Supplier<Boolean> condition;

    public DoCollector(Supplier<Boolean> condition) {
        this.condition = condition;
    }

    @Override
    public Collection<T> collect(Supplier<T> action) {
        var list = new ArrayList<T>();
        do {
            list.add(action.get());
        } while (condition.get());
        return list;
    }
}
