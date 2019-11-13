package com.meti.compile;

import com.meti.compile.unit.*;

import java.util.Set;

public final class JSPotatoCompiler extends UnitCompiler {
	public static final Compiler INSTANCE = init();

	private JSPotatoCompiler(Set<? extends Unit> units, CompilerState state) {
		super(units, state);
	}

	private static Compiler init() {
		var units = Set.of(
				new JSContentArrayUnit(),
				new JSAssignmentUnit(),
				new JSInvocationUnit(),
				new JSInlineUnit(),
				new JSFunctionUnit(),
				new JSVariableUnit(),
				new JSOperationUnit(),
				new JSReturnUnit(),
				new JSIfElseUnit(),
				new JSValueUnit(),
				new JSArrayIndexUnit());
		var generator = new SimpleGenerator();
		var state = new InlineCompilerState(generator);
		return new JSPotatoCompiler(units, state);
	}
}
