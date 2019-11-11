package com.meti.interpret;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.InlineInvocationNode;
import com.meti.assemble.InvocationNode;

import java.util.stream.Collectors;

class InvocationLoader implements Loader {
	@Override
	public boolean canLoad(AssemblyNode node) {
		return node instanceof InlineInvocationNode;
	}

	@Override
	public Statement load(AssemblyNode node, Interpreter interpreter) {
		var invocation = (InvocationNode) node;
		var callerArray = invocation.caller().toArray(String[]::new);
		var callerType = interpreter.find(callerArray);
		var parameters = invocation.values()
				.stream()
				.map(interpreter::loadChild)
				.collect(Collectors.toList());
		return new InlineInvocation(callerType, parameters);
	}
}
