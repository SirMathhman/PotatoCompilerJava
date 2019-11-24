package com.meti.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class SplitUtil {
	public static <T> List<? extends List<? extends T>> split(List<? extends T> content,
	                                                          Predicate<? super T> predicate) {
		var parent = new ArrayList<List<T>>();
		var current = new ArrayList<T>();
		for (T next : content) {
			if (predicate.test(next)) {
				if (!current.isEmpty()) parent.add(current);
				parent.add(Collections.singletonList(next));
				current = new ArrayList<>();
			} else {
				current.add(next);
			}
		}
		if (!current.isEmpty()) parent.add(current);
		return parent;
	}
}
