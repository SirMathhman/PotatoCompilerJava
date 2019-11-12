package com.meti.assemble.node.control;

import com.meti.assemble.node.AssemblyNode;

import java.util.List;

public interface InvocationNode extends AssemblyNode {
	List<String> caller();

	List<AssemblyNode> values();
}
