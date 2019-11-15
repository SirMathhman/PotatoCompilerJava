package com.meti;

import java.util.Optional;

public class ContentMatcher implements Matcher<Match<String>> {

	@Override
	public Optional<? extends Match<String>> match(String string) {
		return Optional.of(new InlineMatch<>(string));
	}
}