package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.Node;
import com.meti.assemble.node.ReturnNode;
import com.meti.lex.token.Keyword;
import com.meti.lex.token.TokenType;

import java.util.Optional;

import static com.meti.assemble.bucket.PredicateBucket.*;
import static com.meti.assemble.bucket.TypePredicate.type;

public class ReturnPattern extends BucketPattern {
	@Override
	protected BucketManager build() {
		return new QueuedBucketManager(
				by(type(TokenType.KEYWORD), valueEquals(Keyword.RETURN)),
				byAny()
		);
	}

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (manager.anyEmpty()) return Optional.empty();
		return Optional.of(new ReturnNode(assembler.assembleChild(manager.at(1))));
	}

	@Override
	public Pattern copy() {
		return new ReturnPattern();
	}
}
