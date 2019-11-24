package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.CountPredicate;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.BlockNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;
import com.meti.lex.tokenizer.Binding;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.*;
import static com.meti.assemble.bucket.TypePredicate.type;

class BlockPattern implements Pattern {
	private final Bucket content = byAny();
	private final Binding<Integer> depth;
	private final Bucket open = by(count(1), type(TokenType.BRACKET), valueEquals(true));
	private final BucketManager manager = new QueuedBucketManager(open, content);

	BlockPattern() {
		this(new Binding<>(0));
	}

	BlockPattern(Binding<Integer> depth) {
		this.depth = depth;
	}

	@Override
	public Optional<Node> collect(Assembler assembler) {
		var content = this.content.content();
		var bracket = CountPredicate.<Token<?>>count(1)
				.and(type(TokenType.BRACKET))
				.and(valueEquals(false));
		var last = content.get(content.size() - 1);
		if (open.present() && bracket.test(last)) {
			depth.set(depth.get() + 1);
			var split = manager.split(1, type(TokenType.SPLIT).and(valueEquals(depth.get())));
			if (!split.isEmpty()) {
				var lastArray = split.get(split.size() - 1);
				lastArray.remove(lastArray.size() - 1);
			}
			var node = Optional.<Node>of(new BlockNode(split.stream()
					.filter(((Predicate<List<? extends Token<?>>>) List::isEmpty).negate())
					.map(tokens -> assembler.copy().assemble(tokens))
					.collect(Collectors.toList())));
			depth.set(depth.get() - 1);
			return node;
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Pattern copy() {
		return new BlockPattern(depth);
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
