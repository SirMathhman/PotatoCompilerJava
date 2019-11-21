package com.meti.compile;

import com.meti.assemble.node.AllocNode;
import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.QuantityNode;
import com.meti.interpret.EvaluateInterpreter;
import com.meti.interpret.evaluate.AllocEvaluator;
import com.meti.interpret.evaluate.IntEvaluator;
import com.meti.interpret.evaluate.QuantityEvaluator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AllocUnitTest {

	@Test
	void compile() {
		var node = new AllocNode(new IntNode(10));
		var interpreter = new EvaluateInterpreter(
				Set.of(new AllocEvaluator(), new IntEvaluator()),
				Collections.emptySet()
		);
		var compiler = new UnitCompiler(new AllocUnit(), new IntUnit());
		var result = compiler.compile(interpreter.interpret(node));
		assertEquals("new Array(10)", result);
	}
}