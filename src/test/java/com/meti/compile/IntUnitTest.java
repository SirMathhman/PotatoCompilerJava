package com.meti.compile;

import com.meti.compile.unit.IntUnit;
import com.meti.interpret.statement.IntStatement;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntUnitTest {

	@Test
	void canCompile() {
		assertTrue(new IntUnit().canCompile(new IntStatement(10)));
	}

	@Test
	void compile() {
		var unit = new IntUnit();
		var result = unit.compile(new IntStatement(10), Mockito.mock(Compiler.class));
		assertEquals("10", result);
	}
}