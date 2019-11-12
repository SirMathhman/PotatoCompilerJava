package com.meti.assemble.node;

import com.meti.lexeme.match.struct.Valued;

public class OperationNode implements AssemblyNode {
    private final AssemblyNode afterNode;
    private final AssemblyNode beforeNode;
    private final Valued operator;

    public OperationNode(Valued operator, AssemblyNode beforeNode, AssemblyNode afterNode) {
        this.operator = operator;
        this.beforeNode = beforeNode;
        this.afterNode = afterNode;
    }

    @Override
    public String toString() {
        return "OperatorNode{" +
                "operator=" + operator +
                ", beforeNode=" + beforeNode +
                ", afterNode=" + afterNode +
                '}';
    }

    public Valued operator() {
		return operator;
    }

    public AssemblyNode after() {
        return afterNode;
    }

    public AssemblyNode before() {
        return beforeNode;
    }
}
