package com.meti.interpret.statement;

import com.meti.interpret.type.Type;
import com.meti.lexeme.match.struct.Keyword;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class InlineFunctionStatement implements FunctionStatement {
	private final String name;
	private final Type returnType;
	private final Map<String, Type> parameters;
	private final Set<Keyword> flags;
	private final List<Statement> content;
	private final List<FunctionStatement> subFunctionStatements;

	public InlineFunctionStatement(String name, Set<Keyword> flags, Map<String, Type> parameters, Type returnType,
                                   List<Statement> content, List<FunctionStatement> subFunctionStatements) {
		this.name = name;
		this.returnType = returnType;
		this.parameters = parameters;
		this.flags = flags;
		this.content = content;
		this.subFunctionStatements = subFunctionStatements;
	}

	@Override
	public String toString() {
		return "InlineFunction{" +
				"name='" + name + '\'' +
				", returnType=" + returnType +
				", parameters=" + parameters +
				", flags=" + flags +
				", content=" + content +
				", subFunctions=" + subFunctionStatements +
				'}';
	}

	@Override
	public List<Statement> content() {
		return content;
	}

	@Override
	public boolean hasModifier(Keyword modifier) {
		return flags.contains(modifier);
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public Map<String, Type> parameters() {
		return parameters;
	}

	@Override
	public List<FunctionStatement> subFunctions() {
		return subFunctionStatements;
	}
}
