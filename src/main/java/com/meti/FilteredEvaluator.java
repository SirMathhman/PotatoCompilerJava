package com.meti;

public interface FilteredEvaluator extends Evaluator {
	boolean canEvaluate(String value);
}
