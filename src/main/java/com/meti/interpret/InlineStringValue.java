package com.meti.interpret;

import com.meti.assemble.StringNode;

class InlineStringValue implements StringValue {
	private final StringNode stringNode;

	public InlineStringValue(StringNode stringNode) {
		this.stringNode = stringNode;
	}

	@Override
	public String value() {
		return stringNode.value();
	}

	@Override
	public Type type() {
		return PrimitiveType.STRING;
	}
}
