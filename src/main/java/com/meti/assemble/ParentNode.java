package com.meti.assemble;

import java.util.List;

public interface ParentNode extends AssemblyNode {
	void append(AssemblyNode node);
	List<? extends AssemblyNode> children();
}
