package com.meti.assemble.node;

import com.meti.lex.token.Operator;

public class OperationNode implements Node {
	private final Node node0;
	private final Operator operator;
	private final Node node1;

	public OperationNode(Node node0, Operator operator, Node node1) {
		this.node0 = node0;
		this.operator = operator;
		this.node1 = node1;
	}

	public Node node0() {
		return node0;
	}

	public Operator operator() {
		return operator;
	}

	public Node node1() {
		return node1;
	}
}
