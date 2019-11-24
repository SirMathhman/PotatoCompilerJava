package com.meti;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ImmutablePipelineTest {

	@Test
	void append() {
		var actual = new ImmutablePipeline<>((Function<String, Integer>) Integer::parseInt)
				.append(integer -> integer * integer)
				.evaluate("10");
		assertEquals(100, actual);
	}

	@Test
	void evaluate() {
		var actual = new ImmutablePipeline<>((Function<String, Integer>) Integer::parseInt)
				.evaluate("100");
		assertEquals(100, actual);
	}
}