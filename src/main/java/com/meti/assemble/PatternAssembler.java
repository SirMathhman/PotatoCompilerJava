package com.meti.assemble;

import java.util.List;
import java.util.function.Predicate;

class PatternAssembler implements Assembler {
	private final List<? extends Pattern> patterns;

	PatternAssembler(List<? extends Pattern> patterns) {
		this.patterns = patterns;
	}

	@Override
	public AssemblyNode assemble(AssemblyState state) {
		return patterns.stream()
				.filter((Predicate<Pattern>) pattern -> pattern.canAssemble(state))
				.findAny()
				.orElseThrow()
				.assemble(state);
	}
}
