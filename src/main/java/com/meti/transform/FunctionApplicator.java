package com.meti.transform;

import com.meti.interpret.statement.*;
import com.meti.interpret.type.AnyType;
import com.meti.interpret.type.ArrayType;
import com.meti.interpret.type.InlineType;
import com.meti.interpret.type.Type;

import java.util.*;
import java.util.stream.Collectors;

class FunctionApplicator implements Applicator {
	private static final String OBJECT_NAME = "a0a";
	private final List<String> depth = new ArrayList<>();
	private final List<Type> types = new ArrayList<>();

	@Override
	public boolean canApply(Statement statement) {
		return statement instanceof Function;
	}

	@Override
	public Statement apply(Statement statement, Transformer transformer) {
		var function = (Function) statement;
		var toReturn = function;
		depth.add(function.name());
		if (function.returnType().isEmpty()) {
			types.add(new InlineType(depth.toArray(String[]::new)));
			var params = function.parameters()
					.keySet()
					.stream()
					.map(InlineVariable::new)
					.collect(Collectors.<Statement>toList());
			var content = List.<Statement>of(new ReturnStatement(new ContentArray(params)));
			toReturn = new InlineFunction(
					function.name(),
					new HashSet<>(),
					function.parameters(),
					new ArrayType(AnyType.INSTANCE),
					content,
					new ArrayList<>());
			for (var subFunction : function.subFunctions()) {
				var appliedSubFunction = (Function) apply(subFunction, transformer);
				var subContent = subFunction.content();
				var parameters = new HashMap<>(subFunction.parameters());
				parameters.put("a0a", new ArrayType(AnyType.INSTANCE));
				replaceVariables(subContent, params);
				var functionToAdd = new InlineFunction(
						appliedSubFunction.name(),
                        Collections.emptySet(),
						parameters,
						subFunction.returnType().orElseThrow(),
						subContent,
						new ArrayList<>());
				transformer.functions().add(functionToAdd);
			}
		}
		depth.remove(function.name());
		return toReturn;
	}

	private void replaceVariable(Statement statement, List<Statement> keySet) {
		for (int i = 0; i < keySet.size(); i++) {
			var index = new ArrayIndex(new InlineStatement(OBJECT_NAME), new InlineIntegerValue(i));
			int finalI = i;
			statement.replaceAll(statement1 -> check(statement1, keySet.get(finalI)), index);
		}
	}

	private boolean check(Statement statement0, Statement statement1) {
		if(!(statement0 instanceof InlineVariable)) return false;
		if(!(statement1 instanceof InlineVariable)) return false;
		var cast0 = (InlineVariable) statement0;
		var cast1 = (InlineVariable) statement1;
		return cast0.name().equals(cast1.name());
	}

	private void replaceVariables(List<? extends Statement> content, List<Statement> keySet) {
		for (Statement statement : content) {
			replaceVariable(statement, keySet);
		}
	}
}
