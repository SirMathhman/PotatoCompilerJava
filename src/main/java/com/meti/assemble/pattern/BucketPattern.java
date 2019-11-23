package com.meti.assemble.pattern;

import com.meti.assemble.bucket.BucketManager;
import com.meti.lex.token.Token;

public abstract class BucketPattern implements Pattern {
	protected final BucketManager manager = build();

	protected abstract BucketManager build();

	@Override
	public Pattern form(Token<?> next) {
		manager.add(next);
		return this;
	}

	@Override
	public void reset() {
		manager.reset();
	}
}
