package com.meti.assemble.pattern;

import com.meti.assemble.AssemblyState;
import com.meti.assemble.node.ArrayIndexNode;
import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.pattern.Pattern;
import com.meti.lexeme.match.format.ListMatch;
import com.meti.lexeme.match.struct.VariableMatch;

public class ArrayIndexPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		if(state.has(VariableMatch.class)) return false;
		var opening = state.first(ListMatch.class, ListMatch::value);
		var closing = state.first(ListMatch.class, match -> !match.value());
		if(opening.isEmpty() || closing.isEmpty()) return false;
		try {
			state.sub(opening.getAsInt() + 1, closing.getAsInt()).assemble();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var opening = state.first(ListMatch.class, ListMatch::value).orElseThrow();
		var closing = state.first(ListMatch.class, match -> !match.value()).orElseThrow();
		var content = state.sub(0, opening).assemble();
		var index = state.sub(opening+ 1, closing).assemble();
		return new ArrayIndexNode(content, index);
	}
}
