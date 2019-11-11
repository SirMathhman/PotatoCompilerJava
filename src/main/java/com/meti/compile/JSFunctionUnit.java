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
		var compiledContent = compiler.compile(function.content());
		var compiledFunctions = compiler.compile(function.subFunctions());
		if (function.hasModifier(SINGLE)) {
			builder.append(compiledContent);
			builder.append(compiledFunctions);
		} else {
			var alias = state.alias(function.name());
			var parameterMAp = function.parameters();
			builder.append("function ")
					.append(alias);
			var params = parameterMAp.keySet().stream()
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
