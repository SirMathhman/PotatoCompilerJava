package com.meti.console;

import java.util.Collection;

class NodeEvaluator implements FilteredEvaluator {
	private final Collection<? extends FilteredEvaluator> evaluators;

	NodeEvaluator(Collection<? extends FilteredEvaluator> evaluators) {
		this.evaluators = evaluators;
	}

	@Override
	public boolean canEvaluate(String value) {
		return evaluators.stream()
				.anyMatch(evaluator -> evaluator.canEvaluate(value));
	}

	@Override
	public String evaluate(String value) {
		return evaluators.stream()
				.filter(evaluator -> evaluator.canEvaluate(value))
				.map(evaluator -> evaluator.evaluate(value))
				.findAny()
				.orElseThrow();
	}
}
