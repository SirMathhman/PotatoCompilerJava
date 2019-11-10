package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.format.ListMatch;
import com.meti.lexeme.match.struct.BlockMatch;
import com.meti.lexeme.match.struct.EndLineMatch;
import com.meti.lexeme.match.struct.Operator;
import com.meti.lexeme.match.struct.OperatorMatch;

import java.util.HashMap;
import java.util.stream.Collectors;

class FunctionPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		var optional = state.first(OperatorMatch.class);
		if (optional.isEmpty()) return false;
		var firstIndex = optional.getAsInt();
		return state.get(firstIndex, OperatorMatch.class).value().equals(Operator.EQUALS) &&
				state.has(firstIndex + 1, BlockMatch.class) &&
				state.get(firstIndex + 1, BlockMatch.class).value() &&
				state.hasLast(BlockMatch.class) &&
				!state.getLast(BlockMatch.class).value();
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var name = state.getFirst(ContentMatch.class).value();
		var paramMap = new HashMap<String, String>();
		var paramStart = state.first(ListMatch.class);
		if (paramStart.isPresent()) {
			var paramEnd = state.index(2, ListMatch.class).orElseThrow();
			var params = state.subMatch(paramStart.getAsInt() + 1, paramEnd, ContentMatch.class);
			for (int i = 0; i < params.size(); i += 2) {
				var key = params.get(i).value();
				var value = params.get(i + 1).value();
				paramMap.put(key, value);
			}
		}
		var blockStartIndex = state.first(BlockMatch.class).orElseThrow();
		var content = state.sub(blockStartIndex + 1, state.size() - 1)
				.split(EndLineMatch.class)
				.stream()
				.map(state::assemble)
				.collect(Collectors.toList());
		return new FunctionNode(name, paramMap, content);
	}
}
