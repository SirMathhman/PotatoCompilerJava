package com.meti.interpret.evaluate;

import com.meti.assemble.node.DeclareNode;
import com.meti.assemble.node.Node;
import com.meti.interpret.Interpreter;
import com.meti.interpret.Primitive;
import com.meti.interpret.Type;
import com.meti.interpret.Variable;
import com.meti.interpret.statement.AssignStatement;
import com.meti.interpret.statement.DeclareStatement;
import com.meti.interpret.statement.GroupStatement;
import com.meti.interpret.statement.Statement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeclareEvaluator implements Evaluator {
    private final Map<? super String, ? super Type> typeMap;

    public DeclareEvaluator() {
        this(new HashMap<>());
    }

    public DeclareEvaluator(Map<? super String, ? super Type> typeMap) {
        this.typeMap = typeMap;
    }

    @Override
    public boolean canEvaluate(Node node) {
        return node instanceof DeclareNode;
    }

    @Override
    public Statement evaluate(Node node, Interpreter interpreter) {
        var declaration = (DeclareNode) node;
        var value = declaration.value().map(interpreter::interpret);
        var type = value.isPresent() ? interpreter.resolve(value.get()) : Primitive.ANY;
        var name = declaration.name();
        var variable = new Variable(type, name);
        typeMap.put(name, type);

        var list = new ArrayList<Statement>();
        list.add(new DeclareStatement(declaration.mutable(), variable));
        value.ifPresent(statement -> list.add(new AssignStatement(variable, statement)));
        return new GroupStatement(list);
    }
}
