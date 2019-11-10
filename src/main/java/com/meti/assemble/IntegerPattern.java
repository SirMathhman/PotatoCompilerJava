package com.meti.assemble;

import com.meti.lexeme.match.primitive.IntegerMatch;

class IntegerPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		return state.hasFirst(IntegerMatch.class) &&
				state.size() == 1;
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var value = state.get(0, IntegerMatch.class).value();
		return new IntegerNode(value);
	}
}
