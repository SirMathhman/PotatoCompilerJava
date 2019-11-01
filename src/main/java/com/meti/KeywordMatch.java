package com.meti;

import java.util.Locale;

enum KeywordMatch implements StringMatch {
	EXTERN,
	SINGLE;

	@Override
	public String value() {
		return name().toLowerCase(Locale.ENGLISH);
	}
}
