package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.struct.Operator;
import com.meti.lexeme.match.struct.OperatorMatch;
import com.meti.lexeme.match.struct.VariableMatch;

class AssignmentPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		return state.hasFirst(VariableMatch.class) &&
				state.has(1, ContentMatch.class) &&
				state.has(2, OperatorMatch.class) &&
				state.get(2, OperatorMatch.class).value().equals(Operator.EQUALS);
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var mutable = state.get(0, VariableMatch.class).value();
		var name = state.get(1, ContentMatch.class).value();
		var subState = state.sub(3);
		var child = state.parent().assemble(subState);
		return new AssignmentNode(name, mutable, child);
	}
}
