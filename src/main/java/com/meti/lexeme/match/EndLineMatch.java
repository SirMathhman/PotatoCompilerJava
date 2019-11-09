package com.meti.lexeme.match;

public class EndLineMatch implements Match<Void> {
	@Override
	public Void value() {
		return null;
	}

	@Override
	public String toString() {
		return "EndLineMatch";
	}
}
