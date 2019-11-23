package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.statement.VariableStatement;
import com.meti.interpret.statement.Statement;

import java.util.HashMap;
import java.util.Map;

public class VariableResolver implements Resolver {
    private final Map<String, ? extends Type> typeMap;

    public VariableResolver(Map<String, ? extends Type> typeMap) {
        this.typeMap = typeMap;
    }

    @Override
    public boolean canResolve(Statement statement) {
        return statement instanceof VariableStatement;
    }

    @Override
    public Type resolve(Statement statement, Interpreter interpreter) {
        var variable = (VariableStatement) statement;
        var name = variable.name();
        var type = typeMap.get(name);
        if (type == null) {
            throw new IllegalArgumentException("Could not find type for name \"" + name + "\", " +
                    name + " has not been defined.");
        }
        return type;
    }
}
