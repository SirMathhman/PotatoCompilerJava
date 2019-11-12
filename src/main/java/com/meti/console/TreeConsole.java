package com.meti.console;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TreeConsole implements Console {
	private final Collection<? extends FilteredEvaluator> evaluators;

	public TreeConsole(FilteredEvaluator... evaluators) {
		this(List.of(evaluators));
	}

	private TreeConsole(Collection<? extends FilteredEvaluator> evaluators) {
		this.evaluators = evaluators;
	}

	@Override
	public Optional<String> run(String input) {
		return evaluators.stream()
				.filter(evaluator -> evaluator.canEvaluate(input))
				.map(evaluator -> evaluator.evaluate(input))
				.findAny();
	}
}
