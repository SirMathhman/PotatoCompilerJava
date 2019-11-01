package com.meti.compile;

import com.meti.assemble.PotatoAssembler;
import com.meti.lexeme.PotatoLexer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {
	@Test
	void compile() {
		var lexer = PotatoLexer.PotatoLexer;
		var assembler = PotatoAssembler.PotatoAssembler;
		var compiler = PotatoCompiler.PotatoCompiler;
		var matches = lexer.parse("Internal.print(\"Hello World!\")");
		var tree = assembler.assembleSingle(matches);
		var result = compiler.compile(tree);
		assertEquals("a0(\"Hello World!\")", result);
	}
}
