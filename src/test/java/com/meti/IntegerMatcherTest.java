package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerMatcherTest {
	@Test
	void matchInvalid() {
		var string = "test";
		var matcher = new IntegerMatcher();
		var result = matcher.match(string);
		assertTrue(result.isEmpty());
	}

	@Test
	void matchValid() {
		var string = "5";
		var matcher = new IntegerMatcher();
		var result = matcher.match(string);
		assertTrue(result.isPresent());
		assertEquals(5, result.get().value());
	}
}
