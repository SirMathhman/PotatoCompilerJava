package com.meti;

import java.util.List;

public interface LexerOutput<T> {
	List<? extends T> list();
}
