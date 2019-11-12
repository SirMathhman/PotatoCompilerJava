package com.meti.interpret;

import java.util.List;

class InlineInvocation implements Invocation {
	private final Type callerType;
	private final List<Statement> parameters;

	public InlineInvocation(Type callerType, List<Statement> parameters) {
		this.callerType = callerType;
		this.parameters = parameters;
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
