package com.meti.interpret.evaluate;

import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.resolve.OperationResolver;
import com.meti.interpret.resolve.Resolver;
import com.meti.interpret.resolve.TypedResolver;
import com.meti.interpret.resolve.VariableResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PotatoInterpreter extends EvaluateInterpreter {
	private static final Map<String, Type> typeMap = new HashMap<>();
	public static final Interpreter INSTANCE = new PotatoInterpreter(
			Set.of(new AllocEvaluator(),
					new DeclareEvaluator(typeMap),
					new IndexEvaluator(),
					new IntEvaluator(),
					new OperationEvaluator(),
					new QuantityEvaluator(),
					new VariableEvaluator()
			),
			Set.of(new TypedResolver(),
					new VariableResolver(typeMap),
					new OperationResolver())
	);

	private PotatoInterpreter(Set<? extends Evaluator> evaluators, Set<? extends Resolver> resolvers) {
		super(evaluators, resolvers);
	}
}
