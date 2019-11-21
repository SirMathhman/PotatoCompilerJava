package com.meti.interpret.evaluate;

import com.meti.assemble.node.DeclarationNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.Primitive;
import com.meti.interpret.Variable;
import com.meti.interpret.statement.AssignStatement;
import com.meti.interpret.statement.DeclareStatement;
import com.meti.interpret.statement.GroupStatement;
import com.meti.interpret.statement.Statement;

import java.util.ArrayList;

public class DeclareEvaluator implements Evaluator {
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
        list.add(new DeclareStatement(declaration.mutable(), variable));
        value.ifPresent(statement -> list.add(new AssignStatement(variable, statement)));
        return new GroupStatement(list);
    }
}
