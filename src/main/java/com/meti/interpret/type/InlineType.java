package com.meti.interpret.type;

public class InlineType implements Type {
	private final String[] name;

	public InlineType(String[] name) {
		this.name = name;
	}

	@Override
	public String[] value() {
		return name;
	}
}
