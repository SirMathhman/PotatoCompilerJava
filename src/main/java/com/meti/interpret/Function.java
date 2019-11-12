package com.meti.interpret;

import com.meti.lexeme.match.struct.Keyword;

import java.util.List;
import java.util.Map;

public interface Function extends Statement {
	List<Statement> content();

	boolean hasModifier(Keyword modifier);

	String name();

	Map<String, Type> parameters();

	List<Function> subFunctions();
}
