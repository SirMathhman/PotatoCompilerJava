package com.meti.lexeme;

public class SimpleLexerState implements LexerState {
	private final String value;
	private int beginning = 0;
	private int end = 1;

	SimpleLexerState(String value) {
		this.value = value;
	}

	@Override
	public void advance() {
		if(end != value.length()) end++;
	}

	@Override
	public String compute() {
		return value.substring(beginning, end);
	}

	@Override
	public boolean hasMoreCharacters() {
		return beginning != value.length();
	}

	@Override
	public boolean hasTerminated() {
		return end == value.length();
	}

	@Override
	public void reset() {
		beginning = end;
		if(end != value.length()) end = beginning + 1;
	}

	@Override
	public String trailing(int count) {
		int bound = Math.min(end + count, value.length());
		return value.substring(end, bound);
	}
}
