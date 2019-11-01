package com.meti;

import java.util.Queue;

public interface Recognizer {
	String name();

	Pattern locate(Queue<? extends Match> matches);
}
