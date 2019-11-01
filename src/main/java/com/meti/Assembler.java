package com.meti;

import java.util.List;

interface Assembler {
	AssemblyTree assemble(List<? extends Match> tokens);
}
