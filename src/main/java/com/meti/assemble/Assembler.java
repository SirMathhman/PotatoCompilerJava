package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;

public interface Assembler {
	AssemblyNode assembleSingle(List<? extends Match> tokens);

	List<AssemblyNode> assembleChildren(List<? extends Match> tokens);
}
