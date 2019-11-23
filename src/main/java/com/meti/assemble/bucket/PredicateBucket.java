package com.meti.assemble.bucket;

import com.meti.lex.token.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateBucket implements Bucket {
	private final List<Token<?>> content = new ArrayList<>();
	private final Predicate<Token<?>>[] predicates;

	private PredicateBucket(Predicate<Token<?>>... predicates) {
		this.predicates = predicates;
	}

	public static Bucket byAny() {
		return by();
	}

	public static Bucket by(Predicate<Token<?>>... predicates) {
		return new PredicateBucket(predicates);
	}

	public static Predicate<Token<?>> valueEquals(Object value) {
		return token -> token.value().equals(value);
	}

	@Override
	public boolean add(Token<?> token) {
		var valid = Arrays.stream(predicates)
				.allMatch(predicate -> predicate.test(token));
		if (valid) content.add(token);
		return valid;
	}

	@Override
	public List<? extends Token<?>> content() {
		return content;
	}

	@Override
	public void empty() {
		content().clear();

		for (Predicate<Token<?>> predicate : predicates) {
			if (predicate instanceof ResettablePredicate<?>) {
				((ResettablePredicate<Token<?>>) predicate).reset();
			}
		}
	}
}