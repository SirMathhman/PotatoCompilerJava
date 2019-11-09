package com.meti;

import java.util.Collection;

class NodeEvaluator implements Evaluator {
	private final Collection<? extends Evaluator> evaluators;

	NodeEvaluator(Collection<? extends Evaluator> evaluators) {
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
