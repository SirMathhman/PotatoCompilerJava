package com.meti.interpret;

import java.util.Collections;

public final class PotatoInterpreter extends ListInterpreter {
	public static final Interpreter INSTANCE = init();

	private PotatoInterpreter(Loader root) {
		super(root);
	}

	private static PotatoInterpreter init() {
		var root = new CollectionLoader(Collections.emptySet());
		return new PotatoInterpreter(root);
	}
}
