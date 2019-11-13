package com.meti.interpret.statement;

import com.meti.interpret.type.Type;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class InlineInvocation implements Invocation {
	private final Type callerType;
	private final List<Statement> parameters;

	public InlineInvocation(Type callerType, List<Statement> parameters) {
		this.callerType = callerType;
		this.parameters = parameters;
	}

	@Override
	public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
		for (int i = 0; i < parameters.size(); i++) {
			if (test.test(parameters.get(i))) {
				parameters.set(i, replacement);
			}
		}

		parameters.forEach(statement -> statement.replaceAll(test, replacement));
	}

	@Override
	public String toString() {
		return "InlineInvocation{" +
				"callerType=" + callerType +
				", parameters=" + parameters +
				'}';
	}

	@Override
	public Type type() {
		return callerType;
	}

	@Override
	public List<Statement> getParameters() {
		return parameters;
	}
}
