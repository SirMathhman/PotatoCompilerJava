package com.meti.interpret.load;

import com.meti.interpret.type.Type;

class GenericType implements Type {
	private final String value;

	public GenericType(String value) {
		this.value = value;
	}

	@Override
	public String[] value() {
		return new String[]{value};
	}
}
