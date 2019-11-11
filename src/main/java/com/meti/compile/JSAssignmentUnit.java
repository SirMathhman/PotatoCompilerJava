package com.meti.compile;

import com.meti.interpret.Assignment;
import com.meti.interpret.Statement;

import java.util.Collections;

class JSAssignmentUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof Assignment;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        var assignment = (Assignment) statement;
        var builder = new StringBuilder();
        var variable = assignment.variable();
        builder.append("var ")
                .append(state.alias(variable.name()))
                .append("=");
        var valueString = compiler.compile(Collections.singletonList(assignment.value()));
        builder.append(valueString)
                .append(";");
        return builder.toString();
    }
}
