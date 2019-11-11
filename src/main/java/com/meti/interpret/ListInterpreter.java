package com.meti.interpret;

import com.meti.assemble.AssemblyNode;

import java.util.*;
import java.util.stream.Collectors;

class ListInterpreter implements Interpreter {
    private final Loader root;
    private final List<Statement> statements = new ArrayList<>();
    private final Set<? extends TypeResolver> resolvers;

    ListInterpreter(Loader root, Set<? extends TypeResolver> resolvers) {
        this.root = root;
        this.resolvers = resolvers;
    }

    @Override
    public List<Statement> statements() {
        return Collections.unmodifiableList(statements);
    }

    @Override
    public Optional<Function> byName(String name) {
        return statements.stream()
                .filter(Function.class::isInstance)
                .map(Function.class::cast)
                .filter(function -> function.name().equals(name))
                .findAny();
    }

    @Override
    public void clear() {
        statements.clear();
    }

    @Override
    public Type find(String... names) {
        if (names.length == 1) {
            try {
                return PrimitiveType.valueOf(names[0].toUpperCase());
            } catch (IllegalArgumentException ignored) {
            }
        }
        var statements = this.statements
                .stream()
                .filter(Function.class::isInstance)
                .map(Function.class::cast)
                .collect(Collectors.toList());
        Function toReturn = null;
        for (String name : names) {
            toReturn = statements
                    .stream()
                    .filter(function -> function.name().equals(name))
                    .findAny()
                    .orElseThrow(() -> throwInvalidFunction(names));
            statements = toReturn.subFunctions();
        }
        if (toReturn == null)
            throw throwInvalidFunction(names);
        return new InlineType(names);
    }

    private IllegalArgumentException throwInvalidFunction(String[] names) {
        return new IllegalArgumentException("Could not find function for name: " + Arrays.toString(names));
    }

    @Override
    public void load(AssemblyNode node) {
        statements.add(loadChild(node));
    }

    @Override
    public Statement loadChild(AssemblyNode node) {
        return root.load(node, this);
    }

    @Override
    public Type resolve(AssemblyNode value) {
        return resolvers.stream()
                .filter(resolver -> resolver.canResolve(value))
                .map(resolver -> resolver.resolve(value, this))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Could not resolve type of node: " + value.toString()));
    }
}
