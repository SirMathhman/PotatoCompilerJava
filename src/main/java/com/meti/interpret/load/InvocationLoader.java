package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.control.InlineInvocationNode;
import com.meti.assemble.node.control.InvocationNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.InlineInvocation;
import com.meti.interpret.statement.Statement;

import java.util.stream.Collectors;

public class InvocationLoader implements Loader {
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
