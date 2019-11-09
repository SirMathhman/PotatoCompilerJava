package com.meti.console;

interface FilteredEvaluator extends Evaluator {
	boolean canEvaluate(String value);
}
