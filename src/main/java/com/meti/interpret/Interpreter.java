package com.meti.interpret;

import com.meti.assemble.node.Node;

interface Interpreter {
    Statement interpret(Node node);

    Type resolve(Statement statement);
}
