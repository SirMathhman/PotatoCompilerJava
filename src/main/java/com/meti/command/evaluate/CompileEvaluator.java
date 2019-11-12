package com.meti.command.evaluate;

import com.meti.compile.JSPotatoCompiler;
import com.meti.console.Evaluator;
import com.meti.interpret.PotatoInterpreter;

public class CompileEvaluator implements Evaluator {
	@Override
	public String evaluate(String value) {
		if (value.toLowerCase().equals("js")) {
			var statements = PotatoInterpreter.INSTANCE.statements();
			return JSPotatoCompiler.INSTANCE.compile(statements);
		} else {
			return "Unsupported compilation type: \"" + value + "\"";
		}
	}
}
