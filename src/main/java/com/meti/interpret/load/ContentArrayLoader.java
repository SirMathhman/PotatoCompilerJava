package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.ContentArrayNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.ContentArray;
import com.meti.interpret.statement.Statement;

import java.util.stream.Collectors;

public class ContentArrayLoader implements Loader {
    @Override
    public boolean canLoad(AssemblyNode node) {
        return node instanceof ContentArrayNode;
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        var contentArray = (ContentArrayNode) node;
        var values = contentArray.value()
                .stream()
                .map(interpreter::loadChild)
                .collect(Collectors.toList());
        return new ContentArray(values);
    }
}
