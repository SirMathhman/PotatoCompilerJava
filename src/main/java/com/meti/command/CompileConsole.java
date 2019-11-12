package com.meti.command;

import com.meti.console.Console;
import com.meti.console.EnumEvaluator;
import com.meti.console.FilteredEvaluator;
import com.meti.console.TreeConsole;

import java.util.Map;

import static com.meti.command.Command.*;

class CompileConsole extends TreeConsole {
	public static final Console INSTANCE = init();

	private CompileConsole(FilteredEvaluator evaluator) {
		super(evaluator);
	}

	private static Console init() {
		var evaluators = Map.of(
				INTERPRET, new InterpretEvaluator(),
				ASSEMBLE, new AssembleEvaluator(),
				GENERATE, new GenerateEvaluator(),
				COMPILE, new CompileEvaluator(),
				CLEAR, new ClearEvaluator(),
				LIST, new ListEvaluator(),
				LOAD, new LoadEvaluator(),
				LEX, new LexEvaluator()
		);
		var evaluator = new EnumEvaluator<>(Command.class, evaluators, " ");
		return new CompileConsole(evaluator);
	}
}
