package com.meti.assemble;

import java.util.Optional;

interface Recognizer {
	String name();

	Optional<AssemblyNode> locate(AssemblerState assemblerState);
}
