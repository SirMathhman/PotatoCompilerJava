package com.meti.assemble.node;

import com.meti.assemble.node.AssemblyNode;

public class ArrayIndexNode implements AssemblyNode {
	private final AssemblyNode content;
	private final AssemblyNode index;

	public ArrayIndexNode(AssemblyNode content, AssemblyNode index) {
		this.content = content;
		this.index = index;
	}

	@Override
	public String toString() {
		return "ArrayIndexNode{" +
				"content=" + content +
				", index=" + index +
				'}';
	}

	public AssemblyNode content() {
		return content;
	}

	public AssemblyNode index() {
		return index;
	}
}
