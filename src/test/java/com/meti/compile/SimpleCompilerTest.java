package com.meti.compile;

import com.meti.assemble.PotatoAssembler;
import com.meti.lexeme.PotatoLexer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCompilerTest {

	@Test
	void compile() {
		var lexer = PotatoLexer.PotatoLexer;
		var assembler = PotatoAssembler.PotatoAssembler;
		var compiler = new SimpleCompiler(List.of(new BlockPattern(), new GroupPattern()), new SimpleGenerator());
		var matches = lexer.parse("single Internal={extern print[value string]}");
		var tree = assembler.assembleSingle(matches);
		var result = compiler.compile(tree);
		assertEquals("function a0(b1){print(b1);}", result);
	}
}