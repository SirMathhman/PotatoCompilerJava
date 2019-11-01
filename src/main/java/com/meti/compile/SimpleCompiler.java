package com.meti.compile;

import com.meti.assemble.AssemblyNode;

import java.util.*;
import java.util.stream.Collectors;

class SimpleCompiler implements Compiler {
	private final List<String> depth = new ArrayList<>();
	private final Map<List<String>, Function> functions = new HashMap<>();
	private final Generator generator;
	private final List<? extends Pattern> patterns;

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
	public List<String> depth() {
		return depth;
	}

	@Override
	public Generator generator() {
		return generator;
	}

	@Override
	public Optional<Function> get(List<String> name) {
		return Optional.ofNullable(functions.get(name));
	}

	@Override
	public void put(String name, Function function) {
		List<String> depthCopy = new ArrayList<>(depth());
		depthCopy.add(name);
		if (functions.put(depthCopy, function) != null) {
			throw new IllegalArgumentException("Function with name \"" + name + "\" already exists.");
		}
	}
}
