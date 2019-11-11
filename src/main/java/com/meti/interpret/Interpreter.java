package com.meti.interpret;

import com.meti.assemble.AssemblyNode;

import java.util.List;
import java.util.Optional;

public interface Interpreter {
    List<Statement> statements();

    Optional<Function> byName(String name);

    void clear();

    Type find(String... names);

    void load(AssemblyNode node);

    Statement loadChild(AssemblyNode node);

	Type resolve(AssemblyNode value);
}