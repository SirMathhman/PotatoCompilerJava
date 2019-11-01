package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;

interface Assembler {
	AssemblyTree assemble(List<? extends Match> tokens);
}
