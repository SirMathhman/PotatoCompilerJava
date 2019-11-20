package com.meti.interpret;

import com.meti.assemble.node.Node;

import java.util.Set;

class EvaluateInterpreter implements Interpreter {
    private final Set<Evaluator> evaluators;
    private final Set<Resolver> resolvers;

    EvaluateInterpreter(Set<Evaluator> evaluators, Set<Resolver> resolvers) {
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
