package com.meti.assemble;

import com.meti.token.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class PredicateBucket implements Bucket {
    private final List<Token<?>> content = new ArrayList<>();
    private final Predicate<Token<?>>[] predicates;

    private PredicateBucket(Predicate<Token<?>>... predicates) {
        this.predicates = predicates;
    }

    static PredicateBucket by(Predicate<Token<?>>... predicates) {
        return new PredicateBucket(predicates);
    }

    static Predicate<Token<?>> equalsType(Object value) {
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
}