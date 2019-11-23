package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.AllocNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.by;
import static com.meti.assemble.bucket.PredicateBucket.valueEquals;
import static com.meti.assemble.bucket.TypePredicate.type;
import static java.util.function.Predicate.not;

public class AllocPattern implements Pattern {
	private final Bucket end = by(count(1), type(TokenType.LIST), valueEquals(false));
	private final Bucket size = by(not(type(TokenType.LIST).and(valueEquals(false))));
	private final Bucket start = by(count(1), type(TokenType.LIST), valueEquals(true));
	private final BucketManager manager = new QueuedBucketManager(start, size, end);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (start.present() && size.present() && end.present()) {
			var node = assembler.assemble(size.content());
			return Optional.of(new AllocNode(node));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Pattern copy() {
		return new AllocPattern();
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
