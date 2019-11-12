package com.meti.compile;

import com.meti.interpret.Statement;

import java.util.Collections;
import java.util.List;

public interface Compiler {
    default String compile(Statement statement) {
        return compile(Collections.singletonList(statement));
    }

    String compile(List<? extends Statement> statements);
}
