package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.AssignmentNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.InlineAssignment;
import com.meti.interpret.statement.InlineDeclaration;
import com.meti.interpret.statement.Statement;

public class AssignmentLoader implements Loader {
	@Override
	public boolean canLoad(AssemblyNode node) {
		return node instanceof AssignmentNode;
	}

	@Override
	public Statement load(AssemblyNode node, Interpreter interpreter) {
		var assignment = (AssignmentNode) node;
		var type = interpreter.resolve(assignment.value());
        var variable = new InlineDeclaration(type, assignment.name(), assignment.isMutable());
		return new InlineAssignment(variable, interpreter.loadChild(assignment.value()));
	}
}
