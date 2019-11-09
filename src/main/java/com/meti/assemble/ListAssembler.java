package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class ListAssembler implements Assembler {
	private final Collection<? extends Recognizer> recognizers;

	ListAssembler(Collection<? extends Recognizer> recognizers) {
		this.recognizers = recognizers;
	}

	@Override
	public AssemblyNode assembleSingle(List<? extends Match> tokens) {
		var nodes = assembleChildren(tokens);
		return new GroupNode(nodes);
	}

	@Override
	public List<AssemblyNode> assembleChildren(List<? extends Match> tokens) {
		var state = new ListAssemblerState(tokens, this);
		return recognizers.stream()
				.map(recognizer -> recognizer.recognize(state))
				.flatMap(Optional::stream)
				.collect(Collectors.toList());
	}
}
