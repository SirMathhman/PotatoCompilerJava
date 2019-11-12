package com.meti.interpret;

import com.meti.lexeme.match.struct.Keyword;

import java.util.List;
import java.util.Map;
import java.util.Set;

class InlineFunction implements Function  {
	private final String name;
	private final Type returnType;
	private final Map<String, Type> parameters;
	private final Set<Keyword> flags;
	private final List<Statement> content;
	private final List<Function> subFunctions;

	InlineFunction(String name, Set<Keyword> flags, Map<String, Type> parameters, Type returnType,
	               List<Statement> content, List<Function> subFunctions) {
		this.name = name;
		this.returnType = returnType;
		this.parameters = parameters;
		this.flags = flags;
		this.content = content;
		this.subFunctions = subFunctions;
	}

	@Override
	public String toString() {
		return "InlineFunction{" +
				"name='" + name + '\'' +
				", returnType=" + returnType +
				", parameters=" + parameters +
				", flags=" + flags +
				", content=" + content +
				", subFunctions=" + subFunctions +
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
	public List<Function> subFunctions() {
		return subFunctions;
	}
}
