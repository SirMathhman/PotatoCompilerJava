package com.meti.assemble.pattern;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.AssemblyState;

interface Pattern {
	boolean canAssemble(AssemblyState state);
	AssemblyNode assemble(AssemblyState state);
}
