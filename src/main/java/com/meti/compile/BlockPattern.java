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
		var generator = compiler.generator();
		var funcID = generator.next();
		var toReturn = "function " + funcID;
		var parameters = block.parameters().keySet().stream()
				.map(s -> generator.next())
				.collect(Collectors.toList());

		compiler.put(block.name(), new Function(funcID, parameters.size()));
		compiler.depth().add(block.name());

		if (!block.modifiers().contains(Modifier.SINGLE)) {
			var parameterString = "(" + String.join(",", parameters) + ")";
			var content = "{" + buildContent(compiler, block, parameters) + "}";
			compiler.depth().remove(block.name());
			return toReturn + parameterString + content;
		} else {
			var children = compiler.compileAll(block.children());
			compiler.depth().remove(block.name());
			return children;
		}
	}

	private String buildContent(Compiler compiler, BlockNode block, List<String> parameters) {
		return block.modifiers().contains(Modifier.EXTERN) ?
				block.name() + "(" + String.join(",", parameters) + ");" :
				compiler.compileAll(block.children());
	}
}
