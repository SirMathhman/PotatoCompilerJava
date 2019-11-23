package com.meti.interpret;

import com.meti.assemble.node.Node;
import com.meti.interpret.statement.Statement;

public interface Interpreter {
    Statement interpret(Node node);

    Type resolve(Statement statement);

    Type resolve(String value);
}
