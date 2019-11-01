package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;

interface Assembler {
	AssemblyNode assemble(List<? extends Match> tokens);
}
