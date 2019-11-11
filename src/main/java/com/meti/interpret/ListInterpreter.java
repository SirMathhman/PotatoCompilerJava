package com.meti.interpret;

import com.meti.assemble.AssemblyNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ListInterpreter implements Interpreter {
	private final Loader root;
	private final List<Statement> statements = new ArrayList<>();

	ListInterpreter(Loader root) {
		this.root = root;
	}

	@Override
	public Function find(String... names) {
		var statements = this.statements
				.stream()
				.filter(Function.class::isInstance)
				.map(Function.class::cast)
				.collect(Collectors.toList());
		Function toReturn = null;
		for (String name : names) {
			toReturn = statements
					.stream()
					.filter(function -> function.name().equals(name))
					.findAny()
					.orElseThrow();
			statements = toReturn.subFunctions();
		}
		if (toReturn == null) throw new IllegalArgumentException("Could not find function for name: " + names);
		return toReturn;
	}

	@Override
	public void load(AssemblyNode node) {
		statements.add(loadChild(node));
	}

	@Override
	public Statement loadChild(AssemblyNode node) {
		return root.load(node, this);
	}
}
