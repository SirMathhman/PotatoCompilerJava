package com.meti.assemble;

import com.meti.CompileException;
import com.meti.lexeme.match.InvocationMatch;
import com.meti.lexeme.match.PrimitiveMatch;
import com.meti.lexeme.match.ValuedMatch;

import java.util.Optional;
import java.util.stream.Collectors;

class InvocationRecognizer implements Recognizer {
	@Override
	public String name() {
		return "invocation";
	}

	@Override
	public Optional<AssemblyNode> locate(AssemblerState state) {
		var indices = state.indices(InvocationMatch.class);
		if (indices.size() < 2) return Optional.empty();
		var names = state.sub(0, indices.get(0), ValuedMatch.class)
				.stream()
				.map(ValuedMatch::value)
				.collect(Collectors.toList());
		var args = state.sub(indices.get(0) + 1, indices.get(1), ValuedMatch.class)
				.stream()
				.collect(Collectors.toMap(ValuedMatch::value, this::findType));
		return Optional.of(new SimpleInvocationNode(names, args));
	}

	private Type findType(ValuedMatch valuedMatch) {
		if (PrimitiveMatch.class.isAssignableFrom(valuedMatch.getClass())) {
			return Primitive.valueOf(((PrimitiveMatch) valuedMatch).type().toUpperCase());
		} else {
			throw new CompileException("Could not find type.");
		}
	}
}
