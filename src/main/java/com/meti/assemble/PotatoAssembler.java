package com.meti.assemble;

import java.util.List;

public class PotatoAssembler extends PatternAssembler {
	public static final Assembler INSTANCE = build();

	private static Assembler build() {
		return new PotatoAssembler(List.of(
				new AssignmentPattern(),
				new IntegerPattern(),
				new StringPattern()
		));
	}

	private PotatoAssembler(List<? extends Pattern> patterns) {
		super(patterns);
	}
}
