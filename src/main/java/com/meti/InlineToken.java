package com.meti;

import java.util.Objects;

class InlineToken implements StringToken {
	private final String value;

	InlineToken(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj || obj != null && getClass() == obj.getClass() &&
				Objects.equals(value, ((StringToken) obj).value());
	}

	@Override
	public String toString() {
		return "InlineToken{" +
				"value='" + value + '\'' +
				'}';
	}
}
