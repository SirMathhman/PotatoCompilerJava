package com.meti;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EnumEvaluatorTest {
	private final FilteredEvaluator evaluator;

	EnumEvaluatorTest() {
		var map = Map.<NameType, Evaluator>of(NameType.FIRST, value -> "test");
		this.evaluator = new EnumEvaluator<>(NameType.class, map, "k");
	}

	@Test
	void canEvaluate() {
		assertTrue(evaluator.canEvaluate("firstksome"));
	}

	@Test
	void evaluate() {
		assertEquals("test", evaluator.evaluate("firstksome"));
	}

	private enum NameType {
		FIRST
	}
}