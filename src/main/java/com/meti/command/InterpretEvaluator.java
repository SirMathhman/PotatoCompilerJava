package com.meti.command;

import com.meti.assemble.ListAssemblyState;
import com.meti.assemble.PotatoAssembler;
import com.meti.console.Evaluator;
import com.meti.interpret.PotatoInterpreter;
import com.meti.lexeme.PotatoLexer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class InterpretEvaluator implements Evaluator {
	@Override
	public String evaluate(String value) {
		var space = value.indexOf(' ');
		var type = value.substring(0, space);
		var lexer = PotatoLexer.INSTANCE;
		var assembler = PotatoAssembler.INSTANCE;
		var interpreter = PotatoInterpreter.INSTANCE;
		if (value.isBlank()) {
			return "Nothing was entered to lexise.";
		}
		if (type.equals("string")) {
			var matches = lexer.parse(value);
			var node = assembler.assemble(new ListAssemblyState(matches, assembler));
			interpreter.load(node);
		} else if (type.equals("path")) {
			var args = value.substring(space + 1).split(" ");
			var path = Paths.get("", args);
			if (Files.exists(path)) {
				String content;
				try (var reader = Files.newBufferedReader(path)) {
					content = reader.lines().collect(Collectors.joining("\n"));
				} catch (IOException e) {
					return e.getMessage();
				}

				var formattedContent = content.replace("\n", "").replace("\t", "");
				var matches = lexer.parse(formattedContent);
				var node = assembler.assemble(new ListAssemblyState(matches, assembler));
				interpreter.load(node);
			} else {
				return "Could not find path: \"" + path.toAbsolutePath() + "\"";
			}
		} else {
			return "Unknown type: \"" + type + "\"";
		}
		return "Sucessfully loaded in code.";
	}
}
