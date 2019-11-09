package com.meti;

import java.util.Collection;

class TreeConsole implements Console {
	private final Collection<? extends Evaluator> evaluators;

	TreeConsole(Collection<? extends Evaluator> evaluators) {
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
