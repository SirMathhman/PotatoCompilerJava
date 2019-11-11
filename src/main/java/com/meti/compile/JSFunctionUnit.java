package com.meti.compile;

import com.meti.interpret.Function;
import com.meti.interpret.Statement;

import java.util.stream.Collectors;

import static com.meti.lexeme.match.struct.Keyword.EXTERNAL;
import static com.meti.lexeme.match.struct.Keyword.SINGLE;

class JSFunctionUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof Function;
	}

	@Override
	public String compile(Statement statement, CompilerState state, Compiler compiler) {
		var builder = new StringBuilder();
		var function = (Function) statement;
		state.name().add(function.name());
		var alias = state.alias(state.name().toArray(String[]::new));
		var compiledContent = compiler.compile(function.content());
		var compiledFunctions = compiler.compile(function.subFunctions());
		state.name().remove(function.name());
		if (function.hasModifier(SINGLE)) {
			builder.append(compiledContent);
			builder.append(compiledFunctions);
		} else {

			var parameterMap = function.parameters();
			builder.append("function ")
					.append(alias);
			var params = parameterMap.keySet().stream()
					.map(state::alias)
					.collect(Collectors.joining(","));
			builder.append("(")
					.append(params)
					.append(")");
			var content = function.hasModifier(EXTERNAL) ?
					function.name() + "(" + params + ");" :
					compiledContent;
			builder.append("{")
					.append(content)
					.append(compiledFunctions)
					.append("}");
		}
		return builder.toString();
	}
}
