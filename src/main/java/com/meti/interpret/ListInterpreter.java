package com.meti.interpret;

import com.meti.assemble.node.AssemblyNode;
import com.meti.interpret.load.Loader;
import com.meti.interpret.resolve.Resolver;
import com.meti.interpret.statement.Function;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.InlineType;
import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

import java.util.*;
import java.util.stream.Collectors;

class ListInterpreter implements Interpreter {
	private final List<String> generics = new ArrayList<>();
	private final Set<? extends Resolver> resolvers;
	private final Loader root;
	private final List<Statement> statements = new ArrayList<>();

	ListInterpreter(Loader root, Set<? extends Resolver> resolvers) {
		this.root = root;
		this.resolvers = resolvers;
	}

	@Override
	public void addGenerics(List<String> generics) {
		this.generics.addAll(generics);
	}

	@Override
	public Optional<Function> byName(String name) {
		return statements.stream()
				.filter(Function.class::isInstance)
				.map(Function.class::cast)
				.filter(function -> function.name().equals(name))
				.findAny();
	}

	@Override
	public void clear() {
		statements.clear();
	}

	@Override
	public Optional<Type> find(String... names) {
		if (names.length == 1) {
			try {
				return Optional.of(PrimitiveType.valueOf(names[0].toUpperCase()));
			} catch (IllegalArgumentException ignored) {
			}
		}
		var statements = this.statements
				.stream()
				.filter(Function.class::isInstance)
				.map(Function.class::cast)
				.collect(Collectors.toList());
		var toReturn = Optional.<Function>empty();
		for (String name : names) {
			toReturn = statements
					.stream()
					.filter(function -> function.name().equals(name))
					.findAny();
			if (toReturn.isPresent()) {
				statements = toReturn.get().subFunctions();
			} else {
				break;
			}
		}
		return toReturn.isEmpty() ?
				Optional.empty() :
				Optional.of(new InlineType(names));
	}

	@Override
	public List<String> generics() {
		return Collections.unmodifiableList(generics);
	}

	@Override
	public void load(AssemblyNode node) {
		statements.add(loadChild(node));
	}

	@Override
	public Statement loadChild(AssemblyNode node) {
		return root.load(node, this);
	}

	@Override
	public void removeGenerics(List<String> generics) {
		this.generics.removeAll(generics);
	}

	@Override
	public Type resolve(Statement value) {
		return resolvers.stream()
				.filter(resolver -> resolver.canResolve(value))
				.map(resolver -> resolver.resolve(value, this))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("Could not resolve type of node: " + value));
	}

	@Override
	public List<Statement> statements() {
		return Collections.unmodifiableList(statements);
	}
}
