package com.meti.assemble.bucket;

import java.util.function.Predicate;

public interface ResettablePredicate<T> extends Predicate<T> {
	void reset();
}
