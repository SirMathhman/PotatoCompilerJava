package com.meti.assemble;

public enum PrimitiveType implements Type {
	INT("int");

	private final String value;

	PrimitiveType(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}
}
