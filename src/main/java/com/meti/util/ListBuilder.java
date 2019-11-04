package com.meti.util;

import java.util.Collection;
import java.util.List;

interface ListBuilder<T> {
    default ListBuilder<T> append(T... ts) {
        return append(List.of(ts));
    }

    ListBuilder<T> append(Collection<? extends T> ts);

    List<T> build();
}
