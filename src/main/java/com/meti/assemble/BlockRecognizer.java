package com.meti.assemble;

import com.meti.lexeme.match.*;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class BlockRecognizer implements Recognizer {
    private final SimpleBlockNodeBuilder builder = new SimpleBlockNodeBuilder();
    private final TypeManager typeManager = new NamedTypeManager();

    @Override
    public Optional<AssemblyNode> locate(AssemblerState state) {
        if (state.contains(InvocationMatch.class)) return Optional.empty();
        if (!state.contains(InlineMatch.class)) return Optional.empty();
        var nameIndex = findName(state);
        setFields(state, nameIndex);
        var node = builder.build();
        return Optional.of(node);
    }

    private Integer findName(AssemblerState state) {
        var optional = state.indexOf(InlineMatch.class);
        if (optional.isEmpty()) throw new IllegalStateException("Name is empty.");
        return optional.get();
    }

    private void setFields(AssemblerState state, int nameIndex) {
        setName(state, nameIndex);
        setParameters(state, nameIndex);
        setModifiers(state, nameIndex);
        setChildren(state, nameIndex);
    }

    private void setName(AssemblerState state, int nameIndex) {
        var nameMatch = state.get(nameIndex, InlineMatch.class);
        var value = nameMatch.value();
        builder.setName(value);
    }

    private void setChildren(AssemblerState state, Integer nameIndex) {
        var size = state.size();
        var firstChildIndex = nameIndex + 2;
        var lastChildIndex = size - 1;
        if (firstChildIndex < size) setChildren(state, firstChildIndex, lastChildIndex);
    }

    private void setChildren(AssemblerState state, int firstChildIndex, int lastChildIndex) {
        var content = state.sub(firstChildIndex, lastChildIndex);
        var assembler = state.assembler();
        var children = assembler.assembleChildren(content);
        builder.setChildren(children);
    }

    private void setParameters(AssemblerState state, Integer nameIndex) {
        var parameterIndex = nameIndex + 1;
        if (state.isType(parameterIndex, ParameterMatch.class)) {
            setParametersFromMatch(state.get(parameterIndex, ParameterMatch.class));
        }
    }

    private void setParametersFromMatch(MapMatch<String, String> match) {
        var parameters = match.map();
        var parameterMap = mapToType(parameters);
        builder.setParameters(parameterMap);
    }

    private Map<String, Type> mapToType(Map<String, String> parameters) {
        return parameters.entrySet()
                .stream()
                .map(typeManager::lookup)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void setModifiers(AssemblerState state, Integer nameIndex) {
        builder.setModifiers(state.sub(0, nameIndex, ValuedMatch.class)
                .stream()
                .map(ValuedMatch::value)
                .map(String::toUpperCase)
                .map(Modifier::valueOf)
                .collect(Collectors.toSet()));
    }
}
