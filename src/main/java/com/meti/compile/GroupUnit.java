package com.meti.compile;

import com.meti.interpret.statement.GroupStatement;
import com.meti.interpret.statement.Statement;

import java.util.stream.Collectors;

public class GroupUnit implements Unit {
	@Override
	public boolean canCompile(Statement value) {
		return value instanceof GroupStatement;
	}

	@Override
	public String compile(Statement value, Compiler compiler) {
		var group = (GroupStatement) value;
		return group.children()
				.stream()
				.map(compiler::compile)
				.collect(Collectors.joining());
	}
}
