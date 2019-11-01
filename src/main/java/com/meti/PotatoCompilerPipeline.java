package com.meti;

import com.meti.assemble.Assembler;
import com.meti.assemble.AssemblyNode;
import com.meti.assemble.PotatoAssembler;
import com.meti.compile.Compiler;
import com.meti.compile.PotatoCompiler;
import com.meti.lexeme.Lexer;
import com.meti.lexeme.PotatoLexer;
import com.meti.lexeme.match.Match;

import java.util.List;

public class PotatoCompilerPipeline implements CompilerPipeline {
	public static final CompilerPipeline Pipeline = new PotatoCompilerPipeline();
	private final Assembler assembler = PotatoAssembler.PotatoAssembler;
	private final Compiler compiler = PotatoCompiler.PotatoCompiler;
	private final Lexer lexer = PotatoLexer.PotatoLexer;

	private String sum = "";

	@Override
	public String sum() {
		return sum;
	}

	@Override
	public String compile(String value) {
		List<? extends Match> matches = lexer.parse(value);
		AssemblyNode root = assembler.assembleSingle(matches);
		String compile = compiler.compile(root);
		sum += compile;
		return compile;
	}
}
