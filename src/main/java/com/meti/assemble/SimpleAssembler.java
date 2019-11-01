package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.*;
import java.util.stream.Collectors;

class SimpleAssembler implements Assembler {
	private final Collection<? extends Recognizer> recognizers;

	SimpleAssembler(Collection<? extends Recognizer> recognizers) {
		this.recognizers = recognizers;
	}

	@Override
	public AssemblyNode assembleSingle(List<? extends Match> tokens) {
		List<AssemblyNode> nodes = assembleChildren(tokens);
		return new GroupNode(nodes);
	}

	@Override
	public List<AssemblyNode> assembleChildren(List<? extends Match> tokens) {
		var state = new ListAssemblerState(tokens, this);
		return recognizers.stream()
				.map(recognizer -> recognizer.locate(state))
				.flatMap(Optional::stream)
				.collect(Collectors.toList());
	}
}
