package com.meti.pipeline;

import com.meti.assemble.pattern.DeclarationPattern;
import com.meti.assemble.pattern.IntegerPattern;
import com.meti.assemble.pattern.PatternAssembler;
import com.meti.compile.*;
import com.meti.interpret.EvaluateInterpreter;
import com.meti.interpret.evaluate.DeclareEvaluator;
import com.meti.interpret.evaluate.IntEvaluator;
import com.meti.interpret.resolve.TypedResolver;
import com.meti.lex.StringLexerInput;
import com.meti.token.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static java.util.Collections.singleton;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PipelineTest {
	@Test
	void variables() {
		var lexer = new TokenLexer(
				new DeclareTokenizer(),
				new OperatorTokenizer(),
				new IntegerTokenizer(),
				new ContentTokenizer()
		);
		var assembler = new PatternAssembler(
				new DeclarationPattern(),
				new IntegerPattern()
		);
		var interpreter = new EvaluateInterpreter(
				Set.of(new DeclareEvaluator(), new IntEvaluator()),
				singleton(new TypedResolver())
		);
		var compiler = new UnitCompiler(
				new GroupUnit(),
				new DeclareUnit(),
				new AssignUnit(),
				new IntUnit()
		);

		var tokens = lexer.lexise(new StringLexerInput("var x = 10"));
		var root = assembler.assemble(tokens.list());
		var statement = interpreter.interpret(root);
		var result = compiler.compile(statement);
		assertEquals("var a0;a0=10;", result);
	}
}
