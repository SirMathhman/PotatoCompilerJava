package com.meti.assemble;

import com.meti.token.Token;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class PatternAssembler implements Assembler {
    private final List<? extends Pattern> patterns;

    PatternAssembler(List<? extends Pattern> patterns) {
        this.patterns = patterns;
    }

    public PatternAssembler(Pattern... patterns) {
        this(List.of(patterns));
    }

    @Override
    public Node assemble(List<? extends Token<?>> tokens) {
        tokens.forEach(this::buildNode);
        return patterns.stream()
                .map(pattern -> pattern.collect(copy()))
                .flatMap(Optional::stream)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There was no content " +
                        "to parse."));
    }

    private Assembler copy() {
        var list = patterns.stream()
                .map(Pattern::copy)
                .collect(Collectors.toList());
        if(list.stream().anyMatch(Objects::isNull)){
            throw new IllegalStateException("Pattern.copy() was not implemented.");
        }
        return new PatternAssembler(list);
    }

    private void buildNode(Token<?> token) {
        patterns.forEach(pattern -> pattern.form(token));
    }
}
