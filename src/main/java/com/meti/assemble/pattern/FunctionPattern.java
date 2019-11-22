package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.FunctionNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Operator;
import com.meti.lex.token.Token;

import java.util.Optional;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.*;
import static com.meti.assemble.bucket.TypePredicate.type;
import static com.meti.lex.token.TokenType.CONTENT;
import static com.meti.lex.token.TokenType.OPERATOR;

public class FunctionPattern implements Pattern {
	private final BucketManager manager = new QueuedBucketManager(
			by(type(CONTENT), count(1)),
			by(type(OPERATOR), valueEquals(Operator.ASSIGN), count(1)),
			byAny()
	);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (manager.allPresent()) {
			var name = manager.at(0, String.class);
			var content = assembler.assembleChild(manager.at(2));
			return Optional.of(new FunctionNode(name, content));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Pattern form(Token<?> next) {
		manager.add(next);
		return this;
	}

	@Override
	public Pattern copy() {
		return new FunctionPattern();
	}
}
