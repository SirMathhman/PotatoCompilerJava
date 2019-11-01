package com.meti.assemble;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleInvocationNode implements InvocationNode {
	private final List<String> methodName;
	private final Map<String, Type> parameters;

	SimpleInvocationNode(List<String> methodName, Map<String, Type> parameters) {
		this.methodName = methodName;
		this.parameters = parameters;
	}

	@Override
	public List<String> methodName() {
		return methodName;
	}

	@Override
	public Map<String, Type> parameters() {
		return parameters;
	}

	@Override
	public List<? extends AssemblyNode> children() {
		return new ArrayList<>();
	}
}
