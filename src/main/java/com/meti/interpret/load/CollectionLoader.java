package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;

import java.util.Collection;

public class CollectionLoader implements Loader {
    private final Collection<? extends Loader> loaders;

    public CollectionLoader(Collection<? extends Loader> loaders) {
        this.loaders = loaders;
    }

    @Override
    public boolean canLoad(AssemblyNode node) {
        return loaders.stream()
                .anyMatch(loader -> loader.canLoad(node));
    }

    @Override
    public Statement load(AssemblyNode node, Interpreter interpreter) {
        return loaders.stream()
                .filter(loader -> loader.canLoad(node))
                .map(loader -> loader.load(node, interpreter))
                .findAny()
				.orElseThrow(() -> new IllegalArgumentException("Could not load node:\n" + node.format()));
    }
}
