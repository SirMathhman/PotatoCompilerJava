package com.meti.compile;

import com.meti.compile.unit.*;
import com.meti.interpret.Primitive;
import com.meti.interpret.Variable;
import com.meti.interpret.statement.AssignStatement;
import com.meti.interpret.statement.DeclareStatement;
import com.meti.interpret.statement.GroupStatement;
import com.meti.interpret.statement.IntStatement;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GroupUnitTest {

	@Test
	void canCompile() {
		assertTrue(new GroupUnit().canCompile(Mockito.mock(GroupStatement.class)));
	}

	@Test
	void compile() {
		var unit = new GroupUnit();
		var compiler = new UnitCompiler(
				new DeclareUnit(),
				new AssignUnit(),
				new IntUnit());
		var variable = new Variable(Primitive.INT, "x");
		var result = unit.compile(new GroupStatement(List.of(
				new DeclareStatement(true, variable),
				new AssignStatement(variable, new IntStatement(10))
		)), compiler);
		assertEquals("var a0;a0=10;", result);
	}
}