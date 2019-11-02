package com.meti.compile;

import org.junit.jupiter.api.Test;

import static com.meti.PotatoCompilerPipeline.Pipeline;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VariableTest {
	@Test
	void compile() {
		Pipeline.compile("single Internal={extern print[value string]}");
		var result = Pipeline.compile("val x=\"test\"\nInternal.print(x)");
		assertEquals("b1(\"Hello World!\");", result);
	}
}
