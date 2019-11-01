package com.meti.assemble;

import java.util.List;
import java.util.Map;

public interface InvocationNode extends AssemblyNode {
	List<String> methodName();

	Map<String, Type> parameters();
}
