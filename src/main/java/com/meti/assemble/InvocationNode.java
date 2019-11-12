package com.meti.assemble;

import java.util.List;

public interface InvocationNode extends AssemblyNode {
	List<String> caller();

	List<AssemblyNode> values();
}
