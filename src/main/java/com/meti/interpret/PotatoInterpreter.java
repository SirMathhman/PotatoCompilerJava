package com.meti.interpret;

import com.meti.interpret.load.*;
import com.meti.interpret.resolve.IntegerResolver;
import com.meti.interpret.resolve.OperationResolver;
import com.meti.interpret.resolve.StringResolver;
import com.meti.interpret.resolve.Resolver;

import java.util.Set;

public final class PotatoInterpreter extends ListInterpreter {
    public static final Interpreter INSTANCE = init();

    private PotatoInterpreter(Loader root, Set<? extends Resolver> resolvers) {
        super(root, resolvers);
    }

    private static Interpreter init() {
        var root = new CollectionLoader(Set.of(
                new ContentArrayLoader(),
                new ArrayIndexLoader(),
                new AssignmentLoader(),
                new InvocationLoader(),
                new OperationLoader(),
                new FunctionLoader(),
                new VariableLoader(),
                new IfElseLoader(),
                new ReturnLoader(),
                new ValueLoader()
        ));
        var resolvers = Set.of(
                new ArrayIndexResolver(),
                new OperationResolver(),
                new VariableResolver(),
                new IntegerResolver(),
                new StringResolver(),
                new ArrayResolver()
        );
        return new PotatoInterpreter(root, resolvers);
    }
}
