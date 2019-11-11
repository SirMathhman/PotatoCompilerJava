package com.meti.command;

import com.meti.console.Evaluator;
import com.meti.interpret.PotatoInterpreter;

class ClearEvaluator implements Evaluator {
	@Override
	public String evaluate(String value) {
		PotatoInterpreter.INSTANCE.clear();
		return "Cleared previous functions";
	}
}
