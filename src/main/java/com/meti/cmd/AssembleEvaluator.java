package com.meti.cmd;

import com.meti.assemble.ListAssemblyState;
import com.meti.assemble.PotatoAssembler;
import com.meti.console.Evaluator;
import com.meti.lexeme.PotatoLexer;
import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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
