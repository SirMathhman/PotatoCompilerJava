package com.meti;

import java.util.Optional;

public class DeclareMatcher implements Matcher<Match<Boolean>> {
	@Override
	public Optional<? extends Match<Boolean>> match(String string) {
		return string.equals("var") || string.equals("val") ?
				Optional.of(new InlineMatch<>(string.equals("var"))) :
				Optional.empty();
	}
}