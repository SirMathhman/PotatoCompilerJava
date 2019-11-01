package com.meti.assemble;

import java.util.Collection;
import java.util.List;

public class PotatoAssembler extends SimpleAssembler {
	public static final Assembler PotatoAssembler = new PotatoAssembler(List.of
			(new BlockRecognizer(),
			new InvocationRecognizer()));

	PotatoAssembler(Collection<? extends Recognizer> recognizers) {
		super(recognizers);
	}
}
