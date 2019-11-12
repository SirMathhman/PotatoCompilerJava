package com.meti.console;

import com.meti.console.EnumEvaluator;
import com.meti.console.Evaluator;
import com.meti.console.TreeConsole;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TreeConsoleTest {

	@Test
	void run() {
		var children = Map.of(TestEnum.ECHO, new EchoEvalutor());
		var evaluator = new EnumEvaluator<>(TestEnum.class, children, " ");
		var console = new TreeConsole(evaluator);
		var output = console.run("echo Hello World!");
		assertEquals("Hello World!", output);
	}

	private static class EchoEvalutor implements Evaluator {
		@Override
		public String evaluate(String value) {
			return value;
		}
	}

	private enum TestEnum {
		ECHO
	}
}