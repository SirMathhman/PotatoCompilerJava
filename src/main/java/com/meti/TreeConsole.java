package com.meti;

import java.util.Collection;
import java.util.List;

class TreeConsole implements Console {
	private final Collection<? extends FilteredEvaluator> evaluators;

	TreeConsole(FilteredEvaluator... evaluators) {
		this(List.of(evaluators));
	}

	private TreeConsole(Collection<? extends FilteredEvaluator> evaluators) {
		this.evaluators = evaluators;
	}

	@Override
	public String run(String input) {
		return evaluators.stream()
				.filter(evaluator -> evaluator.canEvaluate(input))
				.map(evaluator -> evaluator.evaluate(input))
				.findAny()
				.orElseThrow();
	}
}
