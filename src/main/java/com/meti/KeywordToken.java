package com.meti;

import java.util.Locale;

enum KeywordToken implements StringToken {
	EXTERN,
	SINGLE;

	@Override
	public String value() {
		return name().toLowerCase(Locale.ENGLISH);
	}
}
