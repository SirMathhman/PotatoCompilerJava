package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.format.ListMatch;
import com.meti.lexeme.match.struct.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class FunctionPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		var optional = state.first(OperatorMatch.class);
		if (optional.isEmpty()) return false;
		var firstIndex = optional.getAsInt();
		return state.get(firstIndex, OperatorMatch.class).value().equals(Operator.EQUALS);
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var nameIndex = state.first(ContentMatch.class).orElseThrow();
		var name = state.get(nameIndex, ContentMatch.class).value();
		var keywords = state.subMatch(0, nameIndex, KeywordMatch.class)
				.stream()
				.map(KeywordMatch::value)
				.collect(Collectors.toList());
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
		var firstBlockMatch = state.first(BlockMatch.class);
		var isAbstract = firstBlockMatch.isEmpty();
		List<AssemblyNode> content = new ArrayList<>();
		if (firstBlockMatch.isPresent()) {
			var blockStartIndex = firstBlockMatch.getAsInt();

			state.sink();
			content = state.sub(blockStartIndex + 1, state.size() - 1)
					.split(EndLineMatch.class, endLineMatch -> endLineMatch.value() == state.depth())
					.stream()
					.map(AssemblyState::assemble)
					.collect(Collectors.toList());
			state.surface();
		}
		return new FunctionNode(name, keywords, paramMap, content, isAbstract);
	}
}
