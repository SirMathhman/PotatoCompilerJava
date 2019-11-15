package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeclareMatcherTest {
	@Test
	void immutable() {
		var string = "val";
		var matcher = new DeclareMatcher();
		var optional = matcher.match(string);
		assertTrue(optional.isPresent());
		assertFalse(optional.get().value());
	}

	@Test
	void invalid() {
		var string = "test";
		var matcher = new DeclareMatcher();
		var optional = matcher.match(string);
		assertTrue(optional.isEmpty());
	}

	@Test
	void mutable() {
		var string = "var";
		var matcher = new DeclareMatcher();
		var optional = matcher.match(string);
		assertTrue(optional.isPresent());
		assertTrue(optional.get().value());
	}
}
