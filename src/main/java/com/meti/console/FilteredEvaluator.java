package com.meti.console;

public interface FilteredEvaluator extends Evaluator {
	boolean canEvaluate(String value);
}
