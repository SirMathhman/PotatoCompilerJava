package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.IndexNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;

import java.util.Optional;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.by;
import static com.meti.assemble.bucket.PredicateBucket.valueEquals;
import static com.meti.assemble.bucket.TypePredicate.type;
import static com.meti.lex.token.TokenType.LIST;
import static java.util.function.Predicate.not;

public class IndexPattern implements Pattern {
	private final BucketManager manager = new QueuedBucketManager(
			by(not(type(LIST).and(valueEquals(true)))),
			by(type(LIST), valueEquals(true), count(1)),
			by(not(type(LIST).and(valueEquals(false)))),
			by(type(LIST), valueEquals(false), count(1))
	);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (manager.allPresent()) {
			var array = assembler.assembleChild(manager.at(0));
			var index = assembler.assembleChild(manager.at(2));
			return Optional.of(new IndexNode(array, index));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Pattern copy() {
		return new IndexPattern();
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
