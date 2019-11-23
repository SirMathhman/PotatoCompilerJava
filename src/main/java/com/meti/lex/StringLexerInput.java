package com.meti.lex;

import java.util.Optional;

public class StringLexerInput implements LexerInput {
	private final String string;
	private int end = 1;
	private int start = 0;

	public StringLexerInput(String string) {
		this.string = string;
	}

	@Override
	public LexerInput advance() {
		start = end;
		end = start + 1;
		return this;
	}

	@Override
	public String compute() {
		return string.substring(start, end);
	}

	@Override
	public LexerInput extend() {
		end++;
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
		return start < string.length();
	}

	@Override
	public Optional<String> trailing(int count) {
		if (end < string.length()) {
			var endIndex = Math.min(string.length(), end + count);
			return Optional.of(string.substring(end, endIndex));
		} else return Optional.empty();
	}
}
