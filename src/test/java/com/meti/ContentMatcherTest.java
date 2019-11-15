package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContentMatcherTest {
	@Test
	void match() {
		var string = "test";
		var matcher = new ContentMatcher();
		var result = matcher.match(string);
		assertTrue(result.isPresent());
		assertEquals("test", result.get().value());
	}
}
