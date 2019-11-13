package com.meti.interpret.statement;

import com.meti.interpret.statement.Statement;

import java.util.function.Predicate;

public class ArrayIndex implements Statement {
	private Statement content;
	private Statement index;

	public Statement content() {
		return content;
	}

	public Statement index() {
		return index;
	}

	public ArrayIndex(Statement content, Statement index) {
		this.content = content;
		this.index = index;
	}

	@Override
	public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
		if(test.test(content)) content = replacement;
		if(test.test(index)) index = replacement;
	}
}
