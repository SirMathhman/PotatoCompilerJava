package com.meti.interpret;

import com.meti.assemble.node.Node;
import com.meti.interpret.evaluate.Evaluator;
import com.meti.interpret.resolve.Resolver;
import com.meti.interpret.statement.Statement;

import java.util.HashSet;
import java.util.Set;

public class EvaluateInterpreter implements Interpreter {
	private final Set<? extends Evaluator> evaluators;
	private final Set<? extends Resolver> resolvers;

	EvaluateInterpreter(Set<? extends Evaluator> evaluators) {
		this(evaluators, new HashSet<>());
    }

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
				.orElseThrow();
	}

	@Override
	public Type resolve(Statement statement) {
		return resolvers.stream()
				.filter(resolver -> resolver.canResolve(statement))
				.map(resolver -> resolver.resolve(statement))
				.findAny()
				.orElseThrow();
	}
}
