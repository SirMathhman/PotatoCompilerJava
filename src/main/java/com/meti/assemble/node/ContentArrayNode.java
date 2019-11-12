package com.meti.assemble.node;

import com.meti.assemble.node.value.InlineValueNode;

import java.util.List;

public class ContentArrayNode extends InlineValueNode<List<AssemblyNode>> {
	public ContentArrayNode(List<AssemblyNode> value) {
		super(value);
	}
}
