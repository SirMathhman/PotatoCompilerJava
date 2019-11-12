package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;

class VariablePattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		return state.has(ContentMatch.class) && state.isSingle();
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var match = state.get(0, ContentMatch.class);
		return new VariableNode(match.value());
	}
}
