package com.meti.compile;

import com.meti.compile.unit.IndexUnit;
import com.meti.compile.unit.IntUnit;
import com.meti.compile.unit.UnitCompiler;
import com.meti.compile.unit.VariableUnit;
import com.meti.interpret.statement.VariableStatement;
import com.meti.interpret.statement.IndexStatement;
import com.meti.interpret.statement.IntStatement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexUnitTest {
	@Test
	void compile() {
		var compiler = new UnitCompiler(
				new IndexUnit(),
				new IntUnit(),
				new VariableUnit()
		);
		var array = new VariableStatement("array");
		var index = new IntStatement(10);
		var arrayIndex = new IndexStatement(array, index);
		var compile = compiler.compile(arrayIndex);
		assertEquals("a0[10]", compile);
	}
}