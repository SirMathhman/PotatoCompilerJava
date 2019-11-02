package com.meti.assemble;

import com.meti.CompileException;
import com.meti.lexeme.match.InvocationMatch;
import com.meti.lexeme.match.NameMatch;
import com.meti.lexeme.match.ParameterMatch;
import com.meti.lexeme.match.ValuedMatch;

import java.util.*;
import java.util.stream.Collectors;

class BlockRecognizer implements Recognizer {
	@Override
	public Optional<AssemblyNode> recognize(AssemblerState state) {
		return state.has(NameMatch.class) && !state.has(InvocationMatch.class)
				? buildBlock(state)
				: Optional.empty();
	}

	private Optional<AssemblyNode> buildBlock(AssemblerState state) {
		var nameIndex = state.find(NameMatch.class).orElseThrow();
		var name = state.get(nameIndex, NameMatch.class);
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

	private Map<String, Type> buildParameters(AssemblerState state, Integer nameIndex) {
		Map<String, Type> parameterMap = new HashMap<>();
		if (state.has(nameIndex + 1, ParameterMatch.class)) {
			var match = state.get(nameIndex + 1, ParameterMatch.class);
			parameterMap.putAll(buildTypeMap(match.map()));
		}
		return parameterMap;
	}

	private Set<Modifier> buildModifiers(AssemblerState state, Integer nameIndex) {
		return state.slice(0, nameIndex, ValuedMatch.class)
				.stream()
				.map(ValuedMatch::value)
				.map(String::toUpperCase)
				.map(Modifier::valueOf)
				.collect(Collectors.toSet());
	}

	private List<AssemblyNode> buildChildren(AssemblerState state, Integer nameIndex) {
		List<AssemblyNode> result = new ArrayList<>();
		if (nameIndex + 2 < state.size()) {
			var content = state.slice(nameIndex + 2, state.size() - 1);
			result.addAll(state.assembler().assembleChildren(content));
		}
		return result;
	}

	private Map<String, Type> buildTypeMap(Map<String, String> parameters) {
		return parameters.entrySet().stream()
				.map(entry -> Map.entry(entry.getKey(), resolveType(entry.getValue())))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	private Type resolveType(String typeString) {
		try {
			var formattedTypeString = typeString.toUpperCase();
			return Primitive.valueOf(formattedTypeString);
		} catch (IllegalArgumentException e) {
			throw new CompileException("Could not resolve type: " + typeString, e);
		}
	}
}
