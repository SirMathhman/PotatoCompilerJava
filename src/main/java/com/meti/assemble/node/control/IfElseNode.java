package com.meti.assemble.node.control;

import com.meti.assemble.node.AssemblyNode;

public interface IfElseNode extends AssemblyNode {
	AssemblyNode condition();

	AssemblyNode elseBlock();

	AssemblyNode ifBlock();
}
