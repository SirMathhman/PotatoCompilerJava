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

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitCompilerTest {

	@Test
	void compile() {
		var compiler = new UnitCompiler(
				new GroupUnit(),
				new DeclareUnit(),
				new AssignUnit(),
				new IntUnit()
		);
		var variable = new Variable(Primitive.INT, "x");
		var result = compiler.compile(new GroupStatement(List.of(
				new DeclareStatement(true, variable),
				new AssignStatement(variable, new IntStatement(10)))));
		assertEquals("var a0;a0=10;", result);
	}

	@Test
	void generator() {
		var expected = Mockito.mock(Generator.class);
		var compiler = new UnitCompiler(Collections.emptySet(), expected);
		var actual = compiler.generator();
		assertEquals(expected, actual);
	}
}