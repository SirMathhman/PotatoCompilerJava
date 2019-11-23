package com.meti.compile;

import com.meti.assemble.node.VariableNode;
import com.meti.compile.unit.UnitCompiler;
import com.meti.compile.unit.VariableUnit;
import com.meti.interpret.evaluate.EvaluateInterpreter;
import com.meti.interpret.evaluate.VariableEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VariableUnitTest {

	@Test
	void compile() {
		var node = new VariableNode("test");
		var interpreter = new EvaluateInterpreter(
				Set.of(new VariableEvaluator()),
				Collections.emptySet()
		);
		var compiler = new UnitCompiler(new VariableUnit());
		var result = compiler.compile(interpreter.interpret(node));
		assertEquals("a0", result);
	}
}