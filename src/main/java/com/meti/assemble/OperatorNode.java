package com.meti.assemble;

import com.meti.lexeme.match.struct.Valued;

class OperatorNode implements AssemblyNode {
	private final Valued operator;
	private final AssemblyNode value0;
	private final AssemblyNode value1;

	OperatorNode(AssemblyNode value0, Valued operator, AssemblyNode value1) {
		this.value0 = value0;
		this.value1 = value1;
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "OperatorNode{" +
				"operator=" + operator +
				", \n\tvalue0=" + value0 +
				", \n\tvalue1=" + value1 +
				'}';
	}
}
