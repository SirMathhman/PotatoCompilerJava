package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.Node;
import com.meti.assemble.node.QuantityNode;
import com.meti.lex.token.Token;

import java.util.Optional;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.by;
import static com.meti.assemble.bucket.PredicateBucket.valueEquals;
import static com.meti.assemble.bucket.TypePredicate.type;
import static com.meti.lex.token.TokenType.PARENTHESIS;
import static java.util.function.Predicate.not;

public class OrderPattern implements Pattern {
	private final Bucket closeToken = by(count(1), type(PARENTHESIS), valueEquals(false));
	private final Bucket content = by(not(type(PARENTHESIS).and(valueEquals(false))));
	private final Bucket openToken = by(count(1), type(PARENTHESIS), valueEquals(true));
	private final BucketManager manager = new QueuedBucketManager(openToken, content, closeToken);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (openToken.present() && closeToken.present()) {
			var node = assembler.assemble(content.content());
			return Optional.of(new QuantityNode(node));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Pattern copy() {
		return new OrderPattern();
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
