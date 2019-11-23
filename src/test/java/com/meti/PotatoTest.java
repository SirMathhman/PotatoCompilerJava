package com.meti;

import com.meti.assemble.Assembler;
import com.meti.assemble.pattern.PotatoAssembler;
import com.meti.compile.Compiler;
import com.meti.compile.unit.PotatoCompiler;
import com.meti.interpret.Interpreter;
import com.meti.interpret.evaluate.PotatoInterpreter;
import com.meti.lex.Lexer;
import com.meti.lex.StringLexerInput;
import com.meti.lex.token.PotatoLexer;
import com.meti.lex.token.Token;

public class PotatoTest {
	private static final Assembler ASSEMBLER = PotatoAssembler.INSTANCE;
	private static final Compiler COMPILER = PotatoCompiler.INSTANCE;
	private static final Interpreter INTERPRETER = PotatoInterpreter.INSTANCE;
	private static final Lexer<Token<?>> LEXER = PotatoLexer.INSTANCE;

	protected String compile(String value) {
		COMPILER.generator().reset();
		var tokens = LEXER.lexise(new StringLexerInput(value));
		var root = ASSEMBLER.assemble(tokens.list());
		var statement = INTERPRETER.interpret(root);
		return COMPILER.compile(statement);
	}
}
