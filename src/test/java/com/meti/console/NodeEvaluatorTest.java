package com.meti.console;

import com.meti.console.FilteredEvaluator;
import com.meti.console.NodeEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class NodeEvaluatorTest {

	private final FilteredEvaluator evaluator;

	NodeEvaluatorTest() {
		var child = new TestEvaluator();
		var evaluators = Set.of(child);
		this.evaluator = new NodeEvaluator(evaluators);
	}

	@Test
	void canEvaluate() {
		assertTrue(evaluator.canEvaluate("some"));
	}

	@Test
	void evaluate() {
		assertEquals("test", evaluator.evaluate("some"));
	}

	private static class TestEvaluator implements FilteredEvaluator {
		@Override
		public boolean canEvaluate(String value) {
			return true;
		}

		@Override
		public String evaluate(String value) {
			return "test";
		}
	}
}