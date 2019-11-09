package com.meti.assemble;

import com.meti.CompileException;

import java.util.Map;

public class NamedTypeManager implements TypeManager {

    @Override
    public Map.Entry<String, Type> lookup(Map.Entry<String, String> entry) {
        var key = entry.getKey();
        var value = entry.getValue();
        var type = lookup(value);
        return Map.entry(key, type);
    }

    private Type lookup(String typeName) {
        try {
            var upperCaseType = typeName.toUpperCase();
            return Primitive.valueOf(upperCaseType);
        } catch (IllegalArgumentException e) {
            throw new CompileException("Could not resolve type: " + typeName);
        }
    }
}