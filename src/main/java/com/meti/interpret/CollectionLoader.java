package com.meti.interpret;

import com.meti.assemble.AssemblyNode;

import java.util.Collection;

class CollectionLoader implements Loader {
    private final Collection<? extends Loader> loaders;

    CollectionLoader(Collection<? extends Loader> loaders) {
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
