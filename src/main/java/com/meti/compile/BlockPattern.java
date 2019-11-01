package com.meti.compile;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.BlockNode;
import com.meti.assemble.Modifier;

import java.util.List;
import java.util.stream.Collectors;

class BlockPattern implements Pattern {
	@Override
	public boolean canCompile(AssemblyNode node) {
		return node instanceof BlockNode;
	}

	@Override
	public String compile(AssemblyNode node, Compiler compiler) {
		var block = (BlockNode) node;
		if (block.modifiers().contains(Modifier.SINGLE)) {
			return compiler.compileAll(block.children());
		}

		Generator generator = compiler.generator();
		var toReturn = "function " + generator.next();
		var parameters = block.parameters().keySet().stream()
				.map(s -> generator.next())
				.collect(Collectors.toList());
		var parameterString = "(" + String.join(",", parameters) + ")";
		var content = "{" + buildContent(compiler, block, parameters) + "}";
		return toReturn + parameterString + content;
	}

	private String buildContent(Compiler compiler, BlockNode block, List<String> parameters) {
		if (block.modifiers().contains(Modifier.EXTERN)) {
			return block.name() + "(" + String.join(",", parameters) + ");";
		} else {
			return compiler.compileAll(block.children());
		}
	}
}
