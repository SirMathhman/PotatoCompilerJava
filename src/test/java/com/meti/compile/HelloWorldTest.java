package com.meti.compile;

import org.junit.jupiter.api.Test;

import static com.meti.PotatoCompilerPipeline.Pipeline;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {
	@Test
	void compile() {
		Pipeline.compile("single Internal={extern print[value string]}");
		var result = Pipeline.compile("Internal.print(\"Hello World!\")");
		assertEquals("b1(\"Hello World!\");", result);
	}
}
