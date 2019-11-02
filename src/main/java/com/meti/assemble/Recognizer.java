package com.meti.assemble;

import java.util.Optional;

interface Recognizer {
	Optional<AssemblyNode> locate(AssemblerState state);
}
