package com.meti.interpret.statement;

import java.util.function.Predicate;

public interface Statement {
	void replaceAll(Predicate<? super Statement> test, Statement replacement);
}
