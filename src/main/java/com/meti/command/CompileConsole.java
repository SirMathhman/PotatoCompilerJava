package com.meti.command;

import com.meti.console.Console;
import com.meti.console.EnumEvaluator;
import com.meti.console.FilteredEvaluator;
import com.meti.console.TreeConsole;

import java.util.Map;

import static com.meti.command.Command.ASSEMBLE;
import static com.meti.command.Command.LEX;

class CompileConsole extends TreeConsole {
	public static final Console INSTANCE = init();

	private CompileConsole(FilteredEvaluator evaluator) {
		super(evaluator);
	}

	private static Console init() {
		var evaluators = Map.of(
				LEX, new LexEvaluator(),
				ASSEMBLE, new AssembleEvaluator()
		);
		var evaluator = new EnumEvaluator<>(Command.class, evaluators, " ");
		return new CompileConsole(evaluator);
	}
}
