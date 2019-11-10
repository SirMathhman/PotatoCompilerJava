package com.meti.assemble;

import com.meti.lexeme.match.primitive.StringMatch;

class StringPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		return state.has(0, StringMatch.class) && state.size() == 1;
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var value = state.get(0, StringMatch.class).value();
		return new StringNode(value);
	}
}
