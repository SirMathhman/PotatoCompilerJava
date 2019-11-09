package com.meti;

interface FilteredEvaluator extends Evaluator {
	boolean canEvaluate(String value);
}
