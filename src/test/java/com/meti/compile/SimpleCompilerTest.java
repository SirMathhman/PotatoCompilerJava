package com.meti.compile;

import com.meti.assemble.PotatoAssembler;
import com.meti.lexeme.PotatoLexer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCompilerTest {

	@Test
	void compile() {
		var lexer = PotatoLexer.PotatoLexer;
		var assembler = PotatoAssembler.PotatoAssembler;
		var compiler = PotatoCompiler.PotatoCompiler;
		var matches = lexer.parse("single Internal={extern print[value string]}");
		var tree = assembler.assembleSingle(matches);
		var result = compiler.compile(tree);
		assertEquals("function a0(b1){print(b1);}", result);
	}

    @Test
    void put() {
		var map = new HashMap<List<String>, Function>();
		var compiler = new SimpleCompiler(map);
		compiler.put("some", Mockito.mock(InlineFunction.class));
    }
}