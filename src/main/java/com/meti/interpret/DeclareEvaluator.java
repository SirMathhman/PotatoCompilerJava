package com.meti.interpret;

import com.meti.assemble.node.DeclarationNode;
import com.meti.assemble.node.Node;

import java.util.ArrayList;

class DeclareEvaluator implements Evaluator {
    @Override
    public boolean canEvaluate(Node node) {
        return node instanceof DeclarationNode;
    }

    @Override
    public Statement evaluate(Node node, Interpreter interpreter) {
        var declaration = (DeclarationNode) node;
        var value = declaration.value().map(interpreter::interpret);
        var type = value.isPresent() ? interpreter.resolve(value.get()) : Primitive.ANY;
        var variable = new Variable(type, declaration.name());
        var list = new ArrayList<Statement>();
        list.add(new DeclarationStatement(declaration.mutable(), variable));
        value.ifPresent(statement -> list.add(new AssignmentStatement(variable, statement)));
        return new GroupStatement(list);
    }
}
