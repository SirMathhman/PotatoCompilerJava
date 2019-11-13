package com.meti.util;

import java.util.Collection;
import java.util.function.Supplier;

interface PredicateCollector<T> {
    Collection<T> collect(Supplier<T> action);
}
