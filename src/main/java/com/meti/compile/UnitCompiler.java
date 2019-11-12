package com.meti.compile;

import com.meti.interpret.Statement;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class UnitCompiler implements Compiler {
    private final CompilerState state;
    private final Set<? extends Unit> units;

    UnitCompiler(Set<? extends Unit> units, CompilerState state) {
        this.state = state;
        this.units = units;
    }

    @Override
    public String compile(List<? extends Statement> statements) {
        return statements.stream()
                .map(this::compile)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String compile(Statement statement) {
        var compiled = units.stream()
                .filter(unit -> unit.canCompile(statement))
                .map(unit -> unit.compile(statement, state, this))
                .collect(Collectors.joining());
        if (compiled.isBlank()) {
			throw new IllegalArgumentException("Could not find valid unit for " + statement.toString());
        }
        return compiled;
    }
}
