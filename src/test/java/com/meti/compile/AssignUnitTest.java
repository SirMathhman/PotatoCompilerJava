package com.meti.compile;

import com.meti.compile.unit.AssignUnit;
import com.meti.compile.unit.IntUnit;
import com.meti.compile.unit.UnitCompiler;
import com.meti.interpret.Primitive;
import com.meti.interpret.Variable;
import com.meti.interpret.statement.AssignStatement;
import com.meti.interpret.statement.IntStatement;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class AssignUnitTest {

	@Test
	void canCompile() {
		assertTrue(new AssignUnit().canCompile(Mockito.mock(AssignStatement.class)));
	}

	@Test
	void compile() {
		var unit = new AssignUnit();
		var result = unit.compile(new AssignStatement(new Variable(Primitive.INT, "x"), new IntStatement(10)),
				new UnitCompiler(Collections.singleton(new IntUnit())));
		assertEquals("a0=10;", result);
	}
}