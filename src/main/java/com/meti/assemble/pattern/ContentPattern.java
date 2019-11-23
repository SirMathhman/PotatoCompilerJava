package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.Node;
import com.meti.assemble.node.StringNode;
import com.meti.assemble.node.VariableNode;
import com.meti.lex.token.Token;

import java.util.Optional;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.by;
import static com.meti.assemble.bucket.TypePredicate.type;
import static com.meti.lex.token.TokenType.CONTENT;

class ContentPattern implements Pattern {
	private final Bucket bucket = by(type(CONTENT), count(1));
	private final BucketManager manager = new QueuedBucketManager(bucket);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		var value = bucket.single().valueAs(String.class);
		if (bucket.present()) {
			if (value.startsWith("\"")) {
				return Optional.of(new StringNode(value.substring(1, value.length() - 1)));
			} else {
				return Optional.of(new VariableNode(value));
			}
		} else return Optional.empty();
	}

    @Override
	public Pattern copy() {
		return new ContentPattern();
	}

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
