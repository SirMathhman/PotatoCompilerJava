package com.meti.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListBuilder<T> implements ListBuilder<T> {
    private final List<T> list;

    ArrayListBuilder() {
        this(new ArrayList<>());
    }

    public ArrayListBuilder(List<T> list) {
        this.list = list;
    }

    @Override
    public ListBuilder<T> append(Collection<? extends T> ts) {
        list.addAll(ts);
        return new ArrayListBuilder<>(list);
    }

    @Override
    public List<T> build() {
        return list;
    }
}
