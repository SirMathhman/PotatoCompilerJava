package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.Queue;

public interface Recognizer {
	String name();

	Pattern locate(Queue<? extends Match> matches);
}
