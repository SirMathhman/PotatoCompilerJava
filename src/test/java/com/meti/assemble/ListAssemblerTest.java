package com.meti.assemble;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static java.util.Collections.*;

class ListAssemblerTest {
	@Test
	void assembleChildren() {
		var recognizer = new Recognizer() {
			@Override
			public Optional<AssemblyNode> recognize(AssemblerState state) {
				return Optional.empty();
			}
		};
	    var assembler = new ListAssembler(singletonList(recognizer));

	}

	@Test
    void assembleSingle() {
	}
}