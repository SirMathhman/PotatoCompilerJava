package com.meti.interpret.statement;

import com.meti.compile.Compiler;
import com.meti.compile.unit.Unit;

import java.util.stream.Collectors;

public class BlockUnit implements Unit {
	@Override
	public boolean canCompile(Statement statement) {
		return statement instanceof BlockStatement;
	}

	@Override
	public String compile(Statement statement, Compiler compiler) {
		var block = (BlockStatement) statement;
		var children = block.children()
				.stream()
				.map(compiler::compile)
				.collect(Collectors.joining(";"));
		return "{" + children + "}";
	}
}
