package com.meti.assemble;

import com.meti.assemble.node.AssemblyNode;

public interface Assembler {
	AssemblyNode assemble(AssemblyState state);
}
