package com.meti.lexeme.match;

import java.util.Objects;

public class NameMatch implements ValuedMatch {
	private final String value;

	public NameMatch(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj != null && getClass() == obj.getClass() &&
				Objects.equals(value, ((ValuedMatch) obj).value());
	}

	@Override
	public String toString() {
		return "NameMatch{" +
				"value='" + value + '\'' +
				'}';
	}
}
