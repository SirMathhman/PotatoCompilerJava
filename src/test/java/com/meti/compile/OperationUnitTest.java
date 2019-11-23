package com.meti.compile;

import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.OperationNode;
import com.meti.compile.unit.IntUnit;
import com.meti.compile.unit.OperationUnit;
import com.meti.compile.unit.UnitCompiler;
import com.meti.interpret.evaluate.EvaluateInterpreter;
import com.meti.interpret.evaluate.IntEvaluator;
import com.meti.interpret.evaluate.OperationEvaluator;
import com.meti.lex.token.Operator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationUnitTest {

	@Test
	void compile() {
		var node = new OperationNode(
				new IntNode(10),
				Operator.ADD,
				new IntNode(20)
		);
		var interpreter = new EvaluateInterpreter(
				Set.of(new OperationEvaluator(), new IntEvaluator()),
				Collections.emptySet()
		);
		var compiler = new UnitCompiler(new OperationUnit(), new IntUnit());
		var result = compiler.compile(interpreter.interpret(node));
		assertEquals("10+20", result);
	}
}