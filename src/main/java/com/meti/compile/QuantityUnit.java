package com.meti.compile;

import com.meti.interpret.statement.QuantityStatement;
import com.meti.interpret.statement.Statement;

public class QuantityUnit implements Unit {
	@Override
	public boolean canCompile(Statement value) {
		return value instanceof QuantityStatement;
	}

	@Override
	public String compile(Statement value, Compiler compiler) {
		var quantity = (QuantityStatement) value;
		var child = quantity.child();
		return "(" + compiler.compile(child) + ")";
	}
}
