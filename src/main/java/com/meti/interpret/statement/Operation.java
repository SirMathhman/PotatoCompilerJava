package com.meti.interpret.statement;

import com.meti.lexeme.match.struct.Valued;

import java.util.function.Predicate;

public class Operation implements Statement {
	private final Valued operator;
	private Statement after;
	private Statement before;

	@Override
	public String toString() {
		return "Operation{" +
				"operator=" + operator +
				", after=\n\t" + after +
				", before=\n\t" + before +
				'}';
	}

	public Operation(Valued operator, Statement before, Statement after) {
		this.operator = operator;
		this.before = before;
		this.after = after;
	}

	public Statement after() {
		return after;
	}

	public Statement before() {
		return before;
	}

	public Valued operator() {
		return operator;
	}

	@Override
	public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
		if (test.test(before)) before = replacement;
		if (test.test(after)) after = replacement;
	}
}
