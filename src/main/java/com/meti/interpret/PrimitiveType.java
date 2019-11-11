package com.meti.interpret;

public enum PrimitiveType implements Type {
	STRING,
    INTEGER;

	@Override
	public String[] value() {
		return new String[]{name().toLowerCase()};
	}
}
