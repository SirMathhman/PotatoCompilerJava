package com.meti.command.evaluate;

import com.meti.console.Evaluator;
import com.meti.interpret.PotatoInterpreter;

public class ClearEvaluator implements Evaluator {
	@Override
	public String evaluate(String value) {
		PotatoInterpreter.INSTANCE.clear();
		return "Cleared previous functions";
	}
}
