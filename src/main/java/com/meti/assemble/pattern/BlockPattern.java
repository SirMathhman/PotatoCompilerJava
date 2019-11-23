package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.BlockNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.by;
import static com.meti.assemble.bucket.PredicateBucket.valueEquals;
import static com.meti.assemble.bucket.TypePredicate.type;
import static java.util.function.Predicate.not;

class BlockPattern implements Pattern {
	private final Bucket close = by(count(1), type(TokenType.BRACKET), valueEquals(false));
	private final Bucket content = by(not(type(TokenType.BRACKET).and(valueEquals(false))));
	private final Bucket open = by(count(1), type(TokenType.BRACKET), valueEquals(true));
	private final BucketManager manager = new QueuedBucketManager(open, content, close);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (open.present() && close.present()) {
			var content = manager.split(1,
					next -> next.type() == TokenType.SPLIT);
			return Optional.of(new BlockNode(content.stream()
					.map(tokens -> assembler.copy().assemble(tokens))
					.collect(Collectors.toList())));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Pattern copy() {
		return new BlockPattern();
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
