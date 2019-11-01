package com.meti.compile;

class Function {
	private final String name;
	private final int parameterCount;

	Function(String name, int parameterCount) {
		this.name = name;
		this.parameterCount = parameterCount;
	}

	public String name() {
		return name;
	}
}
