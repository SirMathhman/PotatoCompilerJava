package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.GroupStatement;
import com.meti.interpret.statement.Statement;

import java.util.stream.Collectors;

public class GroupUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof GroupStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var group = (GroupStatement) statement;
		return group.children()
				.stream()
				.map(compiler::compile)
				.collect(Collectors.joining());
	}
}
