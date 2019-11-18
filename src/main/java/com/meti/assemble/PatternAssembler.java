package com.meti.assemble;

import com.meti.token.Token;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class PatternAssembler implements Assembler {
    private final Set<? extends Pattern> patterns;

    PatternAssembler(Set<? extends Pattern> patterns) {
        this.patterns = patterns;
    }

    @Override
    public Node assemble(List<? extends Token<?>> tokens) {
        var nodes = tokens.stream()
                .map(this::buildNode)
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        if (nodes.isEmpty()) {
            throw new IllegalArgumentException("There was no content " +
                    "to parse.");
        } else if (nodes.size() == 1) {
            return nodes.get(0);
        } else {
            return new GroupNode(nodes);
        }
    }

    private Optional<Node> buildNode(Token<?> token) {
        return patterns.stream()
                .map((Function<Pattern, Optional<Node>>) pattern -> pattern.form(token, this))
                .findAny()
                .orElseThrow();
    }
}
