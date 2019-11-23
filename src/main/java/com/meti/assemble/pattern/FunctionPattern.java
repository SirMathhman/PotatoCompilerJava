package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.FunctionNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Keyword;
import com.meti.lex.token.Operator;
import com.meti.lex.token.Token;

import java.util.Optional;
import java.util.stream.Collectors;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.*;
import static com.meti.assemble.bucket.TypePredicate.type;
import static com.meti.lex.token.TokenType.*;

public class FunctionPattern implements Pattern {
	private final Bucket assignBucket = by(type(OPERATOR), valueEquals(Operator.ASSIGN), count(1));
	private final Bucket contentBucket = byAny();
	private final Bucket nameBucket = by(type(CONTENT), count(1));
	private final Bucket parameterEnd = by(type(LIST), valueEquals(false), count(1));
	private final Bucket parameterStart = by(type(LIST), valueEquals(true));
	private final Bucket parameters = by(
			type(CONTENT).or(type(ENTRY)),
			token -> parameterStart.present());
	private final Bucket returnMark = by(type(KEYWORD), valueEquals(Keyword.RETURN_MARK));
	private final Bucket returnValue = by(type(CONTENT), count(1));
	private final BucketManager manager = new QueuedBucketManager(
			nameBucket,
			parameterStart,
			parameters,
			parameterEnd,
			returnMark,
			returnValue,
			assignBucket,
			contentBucket
	);

	@Override
	public Optional<Node> collect(Assembler assembler) {
		if (nameBucket.present() && assignBucket.present() && contentBucket.present()) {
			var name = nameBucket.single().valueAs(String.class);
			var content = assembler.assembleChild(contentBucket.content());
			var parameterMap = manager.split(2, type(ENTRY)).stream()
					.collect(Collectors.toMap(
							tokens -> tokens.get(0).valueAs(String.class),
							tokens -> tokens.get(1).valueAs(String.class)));
			String returnType = null;
			if (returnMark.present() && returnValue.present()) {
				returnType = returnValue.single().valueAs(String.class);
			}
			return Optional.of(new FunctionNode(name, parameterMap, returnType, content));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Pattern copy() {
		return new FunctionPattern();
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
