package com.meti.lexeme.match;

import java.util.Locale;

public enum KeywordMatch implements ValuedMatch {
	EXTERN,
	SINGLE;

	@Override
	public String value() {
		return name().toLowerCase(Locale.ENGLISH);
	}
}
