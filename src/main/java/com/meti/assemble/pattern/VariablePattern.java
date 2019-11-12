package com.meti.assemble.pattern;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.AssemblyState;
import com.meti.assemble.node.InlineVariableNode;
import com.meti.lexeme.match.format.ContentMatch;

class VariablePattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		return state.has(ContentMatch.class) && state.isSingle();
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var match = state.get(0, ContentMatch.class);
		return new InlineVariableNode(match.value());
	}
}
