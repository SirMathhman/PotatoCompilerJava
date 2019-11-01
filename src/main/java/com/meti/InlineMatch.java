package com.meti;

import java.util.Objects;

class InlineMatch implements StringMatch {
	private final String value;

	InlineMatch(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj != null && getClass() == obj.getClass() &&
				Objects.equals(value, ((StringMatch) obj).value());
	}

	@Override
	public String toString() {
		return "InlineMatch{" +
				"value='" + value + '\'' +
				'}';
	}
}
