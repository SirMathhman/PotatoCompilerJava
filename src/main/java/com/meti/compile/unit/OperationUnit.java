package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.OperationStatement;
import com.meti.interpret.statement.Statement;

public class OperationUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof OperationStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var operation = (OperationStatement) statement;
		var operator = operation.operator();
		var c0 = compiler.compile(operation.s0());
		var c1 = compiler.compile(operation.s1());
		return c0 + operator.value() + c1;
	}
}
