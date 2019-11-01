package com.meti.assemble;

import com.meti.CompileException;
import com.meti.lexeme.match.InlineMatch;
import com.meti.lexeme.match.ParameterMatch;
import com.meti.lexeme.match.StringMatch;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
        return buildBlock(state, nameOptional.get());
    }

    private Optional<AssemblyNode> buildBlock(AssemblerState state, int nameIndex) {
        var name = state.get(nameIndex, InlineMatch.class);
        var parameterMap = buildParameters(state, nameIndex);
        var modifiers = buildModifiers(state, nameIndex);
        var children = buildChildren(state, nameIndex);
        return Optional.of(new BlockNodeBuilder()
                .withName(name.value())
                .withArguments(parameterMap)
                .withModifiers(modifiers)
                .withChildren(children)
                .build());
    }

    private List<AssemblyNode> buildChildren(AssemblerState state, Integer nameIndex) {
        var content = state.sub(nameIndex + 1);
        return state.parent().assembleChildren(content);
    }

    private HashMap<String, Type> buildParameters(AssemblerState state, Integer nameIndex) {
        var parameters = state.get(nameIndex + 1, ParameterMatch.class).map();
        var parameterMap = new HashMap<String, Type>();
        for (String parameterName : parameters.keySet()) {
            String parameterType = parameters.get(parameterName);
            try {
                parameterMap.put(parameterName, Primitive.valueOf(parameterType.toUpperCase()));
            } catch (IllegalArgumentException e) {
                throw new CompileException("Could not resolve type: " + parameterType);
            }
        }
        return parameterMap;
    }

    private Set<Modifier> buildModifiers(AssemblerState state, Integer nameIndex) {
        return state.sub(0, nameIndex, StringMatch.class)
                .stream()
                .map(StringMatch::value)
                .map(String::toUpperCase)
                .map(Modifier::valueOf)
                .collect(Collectors.toSet());
    }
}
