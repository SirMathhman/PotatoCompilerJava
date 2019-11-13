package com.meti.interpret.type;

import java.util.Arrays;

public class InlineType implements Type {
	private final String[] name;

	public InlineType(String[] name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "InlineType{" +
				"name=" + Arrays.toString(name) +
				'}';
	}

	@Override
	public String[] value() {
		return name;
	}
}
