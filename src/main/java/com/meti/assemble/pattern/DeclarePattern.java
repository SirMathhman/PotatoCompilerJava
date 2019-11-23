package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.DeclareNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Operator;
import com.meti.lex.token.Token;

import java.util.Optional;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.*;
import static com.meti.assemble.bucket.TypePredicate.type;
import static com.meti.lex.token.TokenType.*;

public class DeclarePattern implements Pattern {
	private final BucketManager manager = new QueuedBucketManager(
			by(type(DECLARE), count(1)),
			by(type(CONTENT), count(1)),
			by(type(OPERATOR), count(1), valueEquals(Operator.ASSIGN)),
			byAny()
	);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (manager.allPresent()) {
			var mutable = manager.at(0, Boolean.class);
			var name = manager.at(1, String.class);
			var valueNode = assembler.assembleChild(manager.at(3));
			manager.reset();
			return Optional.of(new DeclareNode(mutable, name, valueNode));
		} else return Optional.empty();
	}

	@Override
	public Pattern copy() {
		return new DeclarePattern();
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
