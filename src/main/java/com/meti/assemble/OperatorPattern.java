package com.meti.assemble;

import com.meti.lexeme.match.struct.OperatorMatch;

class OperatorPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		return state.has(OperatorMatch.class);
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var index = state.first(OperatorMatch.class).orElseThrow();
		var operator = state.get(index, OperatorMatch.class).value();
		var before = state.sub(0, index);
		var after = state.sub(index + 1);
		var beforeNode = state.parent().assemble(before);
		var afterNode = state.parent().assemble(after);
		return new OperatorNode(beforeNode, operator, afterNode);
	}
}