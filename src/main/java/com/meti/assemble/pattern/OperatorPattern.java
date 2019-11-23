package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.Node;
import com.meti.assemble.node.OperationNode;
import com.meti.lex.token.Operator;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

import static com.meti.assemble.bucket.PredicateBucket.by;
import static com.meti.assemble.bucket.PredicateBucket.valueEquals;
import static com.meti.assemble.bucket.TypePredicate.type;
import static java.util.function.Predicate.not;

public class OperatorPattern implements Pattern {
	private final Bucket content0 = by(not(type(TokenType.OPERATOR)));
	private final Bucket content1 = by(not(type(TokenType.OPERATOR)));
	private final Bucket type = by(type(TokenType.OPERATOR),
			not(valueEquals(Operator.ASSIGN)));
	private final BucketManager manager = new QueuedBucketManager(
			content0,
			type,
			content1
	);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (content0.present() && type.present() && content1.present()) {
			var node0 = assembler.assemble(content0.content());
			var operator = type.single().valueAs(Operator.class);
			var node1 = assembler.assemble(content1.content());
			return Optional.of(new OperationNode(node0, operator, node1));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Pattern copy() {
		return new OperatorPattern();
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
