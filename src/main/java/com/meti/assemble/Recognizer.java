package com.meti.assemble;

import java.util.Optional;

public interface Recognizer {
	String name();

	Optional<AssemblyNode> locate(AssemblerState assemblerState);
}
