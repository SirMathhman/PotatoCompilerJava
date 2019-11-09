package com.meti.console;

import com.meti.util.SimpleCatcher;

import java.util.Map;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

public class EnumEvaluator<E extends Enum<E>> implements FilteredEvaluator {
	private final String delimiter;
	private final Class<E> e;
	private final Map<E, ? extends Evaluator> evaluators;

	public EnumEvaluator(Class<E> e, Map<E, ? extends Evaluator> evaluators, String delimiter) {
		this.evaluators = evaluators;
		this.delimiter = delimiter;
		this.e = e;
	}

	@Override
	public boolean canEvaluate(String value) {
		var firstDelimiter = value.indexOf(delimiter);
		var optional = Optional.<E>empty();
		if (firstDelimiter != -1) optional = findEnum(value, firstDelimiter);
		return optional.isPresent();
	}

	private Optional<E> findEnum(String value, int exclusiveIndex) {
		var catcher = new SimpleCatcher<>(() -> findEnumExceptionally(value, exclusiveIndex));
		return catcher.evaluate(empty());
	}

	private Optional<E> findEnumExceptionally(String value, int exclusiveIndex) {
		var enumKey = value.substring(0, exclusiveIndex);
		var enumUpperKey = enumKey.toUpperCase();
		var enumValue = Enum.valueOf(e, enumUpperKey);
		return of(enumValue);
	}

	@Override
	public String evaluate(String value) {
		var firstDelimiter = value.indexOf(delimiter);
		if (firstDelimiter == -1) throw new IllegalArgumentException("Cannot evaluate: " + value);
		return evaluate(value, firstDelimiter);
	}

	private String evaluate(String value, int firstDelimiter) {
		var enumOptional = findEnum(value, firstDelimiter);
		var enumValue = enumOptional.orElseThrow();
		var evaluator = evaluators.get(enumValue);
		var valueWithoutEnum = value.substring(firstDelimiter + 1);
		return evaluator.evaluate(valueWithoutEnum);
	}
}
