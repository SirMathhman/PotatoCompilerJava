package com.meti.interpret.evaluate;

import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.resolve.Resolver;
import com.meti.interpret.statement.Statement;

import java.util.Set;

public class EvaluateInterpreter implements Interpreter {
	private final Set<? extends Evaluator> evaluators;
	private final Set<? extends Resolver> resolvers;

	public EvaluateInterpreter(Set<? extends Evaluator> evaluators, Set<? extends Resolver> resolvers) {
		this.evaluators = evaluators;
		this.resolvers = resolvers;
	}

	@Override
	public Statement interpret(Node node) {
		return evaluators.stream()
				.filter(evaluator -> evaluator.canEvaluate(node))
				.map(evaluator -> evaluator.evaluate(node, this))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("Could not interpret " + node));
	}

	@Override
	public Type resolve(Statement statement) {
		return resolvers.stream()
				.filter(resolver -> resolver.canResolve(statement))
				.map(resolver -> resolver.resolve(statement, this))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("Could not resolve type for statement " + statement));
	}

	@Override
	public Type resolve(String value) {
		return resolvers.stream()
				.filter(resolver -> resolver.canResolve(value))
				.map(resolver -> resolver.resolve(value, this))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("Could not resolve type for statement " + value));
	}
}
