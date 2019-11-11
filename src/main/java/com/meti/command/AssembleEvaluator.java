package com.meti.command;

import com.meti.assemble.AssemblyState;
import com.meti.assemble.ListAssemblyState;
import com.meti.assemble.PotatoAssembler;
import com.meti.console.Evaluator;
import com.meti.lexeme.PotatoLexer;
import com.meti.lexeme.match.struct.EndLineMatch;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.meti.command.InterpretEvaluator.ASSEMBLER;

class AssembleEvaluator implements Evaluator {
	@Override
	public String evaluate(String value) {
		var lexer = PotatoLexer.INSTANCE;
		var assembler = PotatoAssembler.INSTANCE;
		if (value.isBlank()) {
			return "Nothing was entered to lexise.";
		}
		var matches = lexer.parse(value);
		var state = new ListAssemblyState(matches, ASSEMBLER);
		return state.split(EndLineMatch.class, match -> match.value().equals(state.depth()))
				.stream()
				.map(assembler::assemble)
				.map(Objects::toString)
				.collect(Collectors.joining("\n"));
	}
}
