package com.meti.compile;

import java.util.List;

final class PotatoCompiler extends SimpleCompiler {
	public static final Compiler PotatoCompiler = new PotatoCompiler(List.of(new BlockPattern(), new GroupPattern()),
			new SimpleGenerator());

	private PotatoCompiler(List<? extends Pattern> patterns, Generator generator) {
		super(patterns, generator);
	}
}
