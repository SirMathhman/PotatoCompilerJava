package com.meti.assemble.pattern;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.AssemblyState;
import com.meti.assemble.node.value.IntegerNode;
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
