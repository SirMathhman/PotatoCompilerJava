package com.meti.command;

import com.meti.assemble.ListAssemblyState;
import com.meti.assemble.PotatoAssembler;
import com.meti.console.Evaluator;
import com.meti.lexeme.PotatoLexer;

class AssembleEvaluator implements Evaluator {
	@Override
	public String evaluate(String value) {
		var lexer = PotatoLexer.INSTANCE;
		var assembler = PotatoAssembler.INSTANCE;
		if (value.isBlank()) {
			return "Nothing was entered to lexise.";
		}
		var matches = lexer.parse(value);
		var node = assembler.assemble(new ListAssemblyState(matches, assembler));
		return node.toString();
	}
}
