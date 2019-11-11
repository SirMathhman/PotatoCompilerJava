package com.meti.assemble;

import com.meti.lexeme.match.struct.EndLineMatch;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
				.orElseThrow((Supplier<IllegalStateException>) () -> new IllegalStateException("Cannot parse state: " + state))
				.assemble(state);
	}
}
