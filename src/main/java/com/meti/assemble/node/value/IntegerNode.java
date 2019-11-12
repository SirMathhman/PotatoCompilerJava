package com.meti.assemble.node.value;

public class IntegerNode extends InlineValueNode<Integer> {
	public IntegerNode(int value) {
		super(value);
	}

	@Override
	public String toString() {
		return "IntegerNode{" +
				"value=" + value +
				'}';
	}
}
