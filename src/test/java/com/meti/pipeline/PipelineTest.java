package com.meti.pipeline;

import com.meti.assemble.pattern.DeclarePattern;
import com.meti.assemble.pattern.IntPattern;
import com.meti.assemble.pattern.PatternAssembler;
import com.meti.compile.unit.*;
import com.meti.interpret.evaluate.EvaluateInterpreter;
import com.meti.interpret.evaluate.DeclareEvaluator;
import com.meti.interpret.evaluate.IntEvaluator;
import com.meti.interpret.resolve.PrimitiveResolver;
import com.meti.lex.StringLexerInput;
import com.meti.lex.token.*;
import com.meti.lex.tokenizer.ContentTokenizer;
import com.meti.lex.tokenizer.DeclareTokenizer;
import com.meti.lex.tokenizer.IntegerTokenizer;
import com.meti.lex.tokenizer.OperatorTokenizer;
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
				new DeclarePattern(),
				new IntPattern()
		);
		var interpreter = new EvaluateInterpreter(
				Set.of(new DeclareEvaluator(), new IntEvaluator()),
				singleton(new PrimitiveResolver())
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
