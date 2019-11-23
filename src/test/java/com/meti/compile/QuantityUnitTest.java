package com.meti.compile;

import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.QuantityNode;
import com.meti.compile.unit.IntUnit;
import com.meti.compile.unit.QuantityUnit;
import com.meti.compile.unit.UnitCompiler;
import com.meti.interpret.evaluate.EvaluateInterpreter;
import com.meti.interpret.evaluate.IntEvaluator;
import com.meti.interpret.evaluate.QuantityEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QuantityUnitTest {

	@Test
	void compile() {
		var node = new QuantityNode(new IntNode(10));
		var interpreter = new EvaluateInterpreter(
				Set.of(new QuantityEvaluator(), new IntEvaluator()),
				Collections.emptySet()
		);
		var compiler = new UnitCompiler(new QuantityUnit(), new IntUnit());
		var result = compiler.compile(interpreter.interpret(node));
		assertEquals("(10)", result);
	}
}