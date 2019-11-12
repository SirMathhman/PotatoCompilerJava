package com.meti.interpret;

import com.meti.assemble.node.AssemblyNode;
import com.meti.interpret.statement.Function;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.Type;

import java.util.List;
import java.util.Optional;

public interface Interpreter {
	void addGenerics(List<String> generics);

	Optional<Function> byName(String name);

	void clear();

	Optional<Type> find(String... names);

    List<String> generics();

	void load(AssemblyNode node);

	Statement loadChild(AssemblyNode node);

	void removeGenerics(List<String> generics);

	Type resolve(Statement value);

	List<Statement> statements();
}