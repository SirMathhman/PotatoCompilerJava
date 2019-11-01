package com.meti.compile;

import com.meti.assemble.AssemblyNode;

interface Pattern {
	boolean canCompile(AssemblyNode node);
	String compile(AssemblyNode node, Compiler compiler);
}
