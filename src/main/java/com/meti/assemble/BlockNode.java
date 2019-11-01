package com.meti.assemble;

import java.util.Map;
import java.util.Set;

public interface BlockNode extends AssemblyNode {
	Map<String, Type> parameters();

	Set<Modifier> modifiers();

	String name();
}
