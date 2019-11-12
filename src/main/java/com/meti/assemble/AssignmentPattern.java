package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.struct.EndLineMatch;
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
		AssemblyNode child = !state.hasLast(EndLineMatch.class) ?
				state.sub(3).assemble() :
				state.sub(3, state.size() - 1).assemble();
		return new InlineAssignmentNode(name, mutable, child);
	}
}
