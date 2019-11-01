package com.meti.lexeme.match;

import java.util.Locale;

public enum KeywordMatch implements StringMatch {
	EXTERN,
	SINGLE;

	@Override
	public String value() {
		return name().toLowerCase(Locale.ENGLISH);
	}
}
