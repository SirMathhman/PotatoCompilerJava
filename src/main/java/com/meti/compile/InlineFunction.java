package com.meti.compile;

class InlineFunction implements Function {
	private final String name;

	InlineFunction(String name) {
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}
}
