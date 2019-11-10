package com.meti.assemble;

import java.util.List;

public final class PotatoAssembler extends PatternAssembler {
	public static final Assembler INSTANCE = build();

	private static Assembler build() {
		return new PotatoAssembler(List.of(
				new FunctionPattern(),
				new ContentArrayPattern(),
				new AssignmentPattern(),
				new InvocationPattern(),
				new OperatorPattern(),
				new VariablePattern(),
				new IntegerPattern(),
				new StringPattern()
		));
	}

	private PotatoAssembler(List<? extends Pattern> patterns) {
		super(patterns);
	}
}
