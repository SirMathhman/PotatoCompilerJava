package com.meti.interpret.statement;

import java.util.Objects;
import java.util.function.Predicate;

public class InlineStatement implements Statement {
	private final String value;

	public InlineStatement(String value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InlineStatement that = (InlineStatement) o;
		return Objects.equals(value, that.value);
	}

	@Override
	public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
	}

	public String value() {
		return value;
	}
}
