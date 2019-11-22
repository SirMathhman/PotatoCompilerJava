package com.meti.interpret.evaluate;

import com.meti.assemble.node.BlockNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.BlockStatement;
import com.meti.interpret.statement.Statement;

import java.util.stream.Collectors;

public class BlockEvaluator implements Evaluator {
	@Override
	public boolean canEvaluate(Node node) {
		return node instanceof BlockNode;
	}

	@Override
	public Statement evaluate(Node node, Interpreter interpreter) {
		var block = (BlockNode) node;
		var statements = block.nodes()
				.stream()
				.map(interpreter::interpret)
				.collect(Collectors.toList());
		return new BlockStatement(statements);
	}
}
