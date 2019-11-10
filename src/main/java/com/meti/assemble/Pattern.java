package com.meti.assemble;

interface Pattern {
	boolean canAssemble(AssemblyState state);
	AssemblyNode assemble(AssemblyState state);
}
