package com.meti.lex;

import java.util.Optional;

public class StringLexerInput implements LexerInput {
	private final String string;
	private int endExclusive = 1;
	private int startInclusive = 0;

	public StringLexerInput(String string) {
		this.string = string;
	}

	@Override
	public LexerInput advance() {
		startInclusive = endExclusive;
		endExclusive = startInclusive + 1;
		return this;
	}

	@Override
	public String compute() {
		return string.substring(startInclusive, endExclusive);
	}

	@Override
	public LexerInput extend() {
		if (endExclusive == string.length() + 1) {
			throw new IllegalStateException("No more characters to extend.");
		}
		endExclusive++;
		return this;
	}

	@Override
	public LexerInput skipWhitespace() {
		while (compute().charAt(0) == ' ') {
			advance();
		}
		return this;
	}

	@Override
	public boolean hasMoreToScan() {
		return startInclusive < string.length();
	}

	@Override
	public Optional<String> trailing(int count) {
		if (endExclusive < string.length()) {
			var endIndex = Math.min(string.length(), endExclusive + count);
			return Optional.of(string.substring(endExclusive, endIndex));
		} else return Optional.empty();
	}
}
