package com.meti.command;

import com.meti.console.Evaluator;
import com.meti.interpret.PotatoInterpreter;

import java.util.stream.Collectors;

class ListEvaluator implements Evaluator {

	@Override
	public String evaluate(String value) {
		if(value.isBlank()) {
			return PotatoInterpreter.INSTANCE.statements()
					.stream()
					.map(Object::toString)
					.collect(Collectors.joining("\n"));
		} else {
			return PotatoInterpreter.INSTANCE.byName(value)
					.map(Object::toString)
					.orElse("No such function with name \"" + value + "\" was found.");
		}
	}
}
