package com.meti.lexeme.match;

class InvocationMatch implements Match {
	private final boolean isOpening;

	InvocationMatch(boolean isOpening) {
		this.isOpening = isOpening;
	}
}
