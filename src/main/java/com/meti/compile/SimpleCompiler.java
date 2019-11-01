package com.meti.compile;

import com.meti.assemble.AssemblyNode;

import java.util.List;
import java.util.stream.Collectors;

class SimpleCompiler implements Compiler {
	private final List<? extends Pattern> patterns;
	private final Generator generator;

	SimpleCompiler(List<? extends Pattern> patterns, Generator generator) {
		this.patterns = patterns;
		this.generator = generator;
	}

	@Override
	public String compile(AssemblyNode node) {
		return patterns.stream()
				.filter(pattern -> pattern.canCompile(node))
				.map(pattern -> pattern.compile(node, this))
				.findAny()
				.orElseThrow();
	}

	@Override
	public String compileAll(List<? extends AssemblyNode> children) {
		return children.stream()
				.map(this::compile)
				.collect(Collectors.joining());
	}

	@Override
	public Generator generator() {
		return generator;
	}
}
