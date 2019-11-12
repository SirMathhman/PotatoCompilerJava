package com.meti.interpret.type;

public enum PrimitiveType implements Type {
	STRING,
	INT,
	BOOLEAN;

	@Override
	public String[] value() {
		return new String[]{name().toLowerCase()};
	}
}
