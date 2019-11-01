package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class SimpleAssembler implements Assembler {
	private final Collection<? extends Recognizer> recognizers;

	SimpleAssembler(Collection<? extends Recognizer> recognizers) {
		this.recognizers = recognizers;
	}

	@Override
	public AssemblyNode assemble(List<? extends Match> tokens) {
		Queue<? extends Match> tokenQueue = new PriorityQueue<>(tokens);

		return null;
	}
}
