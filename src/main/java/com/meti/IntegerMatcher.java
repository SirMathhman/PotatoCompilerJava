package com.meti;

import java.util.Optional;

class IntegerMatcher implements Matcher<Match<Integer>> {
	@Override
	public Optional<? extends Match<Integer>> match(String string) {
		return string.chars().allMatch(Character::isDigit) ?
				Optional.of(new InlineMatch<>(Integer.parseInt(string))) :
				Optional.empty();
	}
}
