package com.meti.assemble.pattern;

import com.meti.assemble.AssemblyState;
import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.OperatorNode;
import com.meti.lexeme.match.struct.BlockMatch;
import com.meti.lexeme.match.struct.OperatorMatch;

public class OperatorPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		if (!state.has(OperatorMatch.class)) return false;
		var firstOperator = state.first(OperatorMatch.class);
		if (firstOperator.isEmpty()) return false;
		return !state.has(firstOperator.getAsInt() + 1, BlockMatch.class);
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var index = state.first(OperatorMatch.class).orElseThrow();
		var operator = state.get(index, OperatorMatch.class).value();
		var before = state.sub(0, index);
		var after = state.sub(index + 1);
		var beforeNode = state.parent().assemble(before);
		var afterNode = state.parent().assemble(after);
		return new OperatorNode(operator, beforeNode, afterNode);
	}
}