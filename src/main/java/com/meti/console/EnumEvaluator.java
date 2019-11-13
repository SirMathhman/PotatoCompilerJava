package com.meti.console;

import com.meti.util.Catcher;

import java.util.Map;
import java.util.Optional;

import static java.util.Optional.of;

public class EnumEvaluator<E extends Enum<E>> implements FilteredEvaluator {
    private final String delimiter;
    private final Class<E> enumClass;
    private final Map<E, ? extends Evaluator> evaluators;

    public EnumEvaluator(Class<E> enumClass, Map<E, ? extends Evaluator> evaluators, String delimiter) {
        this.evaluators = evaluators;
        this.delimiter = delimiter;
        this.enumClass = enumClass;
    }

    @Override
    public boolean canEvaluate(String value) {
        var firstDelimiter = value.indexOf(delimiter);
        var optional = Optional.<E>empty();
        if (firstDelimiter != -1) optional = findEnum(value, firstDelimiter);
        return optional.isPresent();
    }

    private Optional<E> findEnum(String value, int exclusiveIndex) {
        return Catcher.create().evaluate(() -> findEnumExceptionally(value, exclusiveIndex), Optional.empty());
    }

    private Optional<E> findEnumExceptionally(String value, int exclusiveIndex) {
        var enumKey = value.substring(0, exclusiveIndex);
        var enumUpperKey = enumKey.toUpperCase();
        var enumValue = Enum.valueOf(enumClass, enumUpperKey);
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
