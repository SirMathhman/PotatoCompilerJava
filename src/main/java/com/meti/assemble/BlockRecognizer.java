package com.meti.assemble;

import com.meti.CompileException;
import com.meti.lexeme.match.InlineMatch;
import com.meti.lexeme.match.InvocationMatch;
import com.meti.lexeme.match.ParameterMatch;
import com.meti.lexeme.match.ValuedMatch;

import java.util.*;
import java.util.stream.Collectors;

class BlockRecognizer implements Recognizer {
    @Override
    public String name() {
        return "function";
    }

    @Override
    public Optional<AssemblyNode> locate(AssemblerState state) {
        var nameOptional = state.indexOf(InlineMatch.class);
        if (nameOptional.isEmpty()) return Optional.empty();
        if(state.indexOf(InvocationMatch.class).isPresent()) return Optional.empty();
        return buildBlock(state, nameOptional.get());
    }

    private Optional<AssemblyNode> buildBlock(AssemblerState state, int nameIndex) {
        var name = state.get(nameIndex, InlineMatch.class);
        var parameterMap = buildParameters(state, nameIndex);
        var modifiers = buildModifiers(state, nameIndex);
        var children = buildChildren(state, nameIndex);
        return Optional.of(new SimpleBlockNodeBuilder()
                .withName(name.value())
                .withArguments(parameterMap)
                .withModifiers(modifiers)
                .withChildren(children)
                .build());
    }

    private List<AssemblyNode> buildChildren(AssemblerState state, Integer nameIndex) {
        if(nameIndex + 2 >= state.size()) return new ArrayList<>();
        var content = state.sub(nameIndex + 2, state.size() - 1);
        return state.parent().assembleChildren(content);
    }

    private Map<String, Type> buildParameters(AssemblerState state, Integer nameIndex) {
        if(state.isType(nameIndex + 1, ParameterMatch.class)) {
            var parameters = state.get(nameIndex + 1, ParameterMatch.class).map();
            Map<String, Type> parameterMap = new HashMap<>();
            for (String parameterName : parameters.keySet()) {
                String parameterType = parameters.get(parameterName);
                try {
                    parameterMap.put(parameterName, Primitive.valueOf(parameterType.toUpperCase()));
                } catch (IllegalArgumentException e) {
                    throw new CompileException("Could not resolve type: " + parameterType);
                }
            }
            return parameterMap;
        } else {
            return new HashMap<>();
        }
    }

    private Set<Modifier> buildModifiers(AssemblerState state, Integer nameIndex) {
        return state.sub(0, nameIndex, ValuedMatch.class)
                .stream()
                .map(ValuedMatch::value)
                .map(String::toUpperCase)
                .map(Modifier::valueOf)
                .collect(Collectors.toSet());
    }
}
