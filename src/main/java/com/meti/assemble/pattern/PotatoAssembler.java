package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;

public class PotatoAssembler extends PatternAssembler {
	public static final Assembler assembler = new PotatoAssembler(
			new AllocPattern(),
			new BlockPattern(),
			new DeclarePattern(),
			new IndexPattern(),
			new IntPattern(),
			new OperatorPattern(),
			new OrderPattern(),
			new VariablePattern()
	);

	private PotatoAssembler(Pattern... patterns) {
		super(patterns);
	}
}
