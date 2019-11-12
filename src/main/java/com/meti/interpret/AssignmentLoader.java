package com.meti.interpret;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.AssignmentNode;

class AssignmentLoader implements Loader {
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
