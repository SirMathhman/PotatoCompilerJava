package com.meti.interpret.statement;

import com.meti.interpret.type.Type;
import com.meti.lexeme.match.struct.Keyword;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Function extends Statement {
	Optional<Type> returnType();

	List<Statement> content();

	boolean hasModifier(Keyword modifier);

	String name();

	Map<String, Type> parameters();

	List<Function> subFunctions();
}
