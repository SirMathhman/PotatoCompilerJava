package com.meti.util;

import com.meti.util.SimpleCatcher;
import com.meti.util.Tryable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCatcherTest {

	@Test
	void evaluate() {
		var value = new SimpleCatcher<>((Tryable<String>) () -> {
			throw new Exception();
		}).evaluate("test");
		assertEquals("test", value);
	}
}