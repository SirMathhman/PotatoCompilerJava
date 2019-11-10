package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.format.SeparatorMatch;
import com.meti.lexeme.match.struct.ArgumentMatch;
import com.meti.lexeme.match.struct.ChildMatch;

import java.util.stream.Collectors;

class InvocationPattern implements Pattern {
	@Override
	public boolean canAssemble(AssemblyState state) {
		var contentIndex = state.first(ContentMatch.class);
		var argIndex = state.first(ArgumentMatch.class);
		return contentIndex.isPresent() && argIndex.isPresent() &&
				(argIndex.getAsInt() >= contentIndex.getAsInt()) &&
				state.get(argIndex.getAsInt(), ArgumentMatch.class).value() &&
				state.hasLast(ArgumentMatch.class) &&
				!state.getLast(ArgumentMatch.class).value();
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		var firstIndex = state.first(ArgumentMatch.class);
		var content = state.sub(0, firstIndex.orElseThrow());
		var caller = content.splitByMatch(ChildMatch.class, ContentMatch.class)
				.stream()
				.map(match -> match.get(0))
				.map(ContentMatch::value)
				.collect(Collectors.toList());
		var sub = state.sub(firstIndex.getAsInt() + 1, state.size() - 1);
		var matches = sub.split(SeparatorMatch.class)
				.stream()
				.map(state::assemble)
				.collect(Collectors.toList());
		return new InvocationNode(caller, matches);
	}
}
