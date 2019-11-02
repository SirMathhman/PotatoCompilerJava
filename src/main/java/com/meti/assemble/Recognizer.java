package com.meti.assemble;

import java.util.Optional;

interface Recognizer {
	Optional<AssemblyNode> recognize(AssemblerState state);
}
