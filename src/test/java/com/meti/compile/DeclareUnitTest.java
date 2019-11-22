package com.meti.compile;

import com.meti.compile.unit.DeclareUnit;
import com.meti.compile.unit.UnitCompiler;
import com.meti.interpret.Primitive;
import com.meti.interpret.Variable;
import com.meti.interpret.statement.DeclareStatement;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DeclareUnitTest {

	@Test
	void canCompile() {
		assertTrue(new DeclareUnit().canCompile(Mockito.mock(DeclareStatement.class)));
	}

	@Test
	void compile() {
		var unit = new DeclareUnit();
		var result = unit.compile(new DeclareStatement(true, new Variable(Primitive.ANY, "x")),
				new UnitCompiler());
		assertEquals("var a0;", result);
	}
}