package com.meti.interpret.type;

public enum PrimitiveType implements Type {
	STRING,
	INT,
	BOOLEAN,
	DOUBLE,
	VOID;

	@Override
	public String[] value() {
		return new String[]{name().toLowerCase()};
	}
}
