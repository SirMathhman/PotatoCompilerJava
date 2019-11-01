package com.meti.compile;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.GroupNode;

import java.util.stream.Collectors;

class GroupPattern implements Pattern {
	@Override
	public boolean canCompile(AssemblyNode node) {
		return node instanceof GroupNode;
	}

	@Override
	public String compile(AssemblyNode node, Compiler compiler) {
		return node.children().stream()
				.map(compiler::compile)
				.collect(Collectors.joining());
	}
}
