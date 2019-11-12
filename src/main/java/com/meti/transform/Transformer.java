package com.meti.transform;

import com.meti.interpret.statement.Statement;

import java.util.List;
import java.util.stream.Collectors;

public interface Transformer {
    List<Statement> functions();

    default List<Statement> transform(List<Statement> statements) {
        return statements.stream()
                .map(this::transform)
                .collect(Collectors.toList());
    }

    Statement transform(Statement other);
}
