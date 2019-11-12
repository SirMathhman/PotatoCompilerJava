package com.meti.interpret;

import com.meti.interpret.load.*;
import com.meti.interpret.resolve.IntegerResolver;
import com.meti.interpret.resolve.StringResolver;
import com.meti.interpret.resolve.TypeResolver;

import java.util.Set;

public final class PotatoInterpreter extends ListInterpreter {
    public static final Interpreter INSTANCE = init();

    private PotatoInterpreter(Loader root, Set<? extends TypeResolver> resolvers) {
        super(root, resolvers);
    }

    private static Interpreter init() {
        var root = new CollectionLoader(Set.of(
                new AssignmentLoader(),
                new InvocationLoader(),
                new FunctionLoader(),
                new VariableLoader(),
                new IfElseLoader(),
                new ReturnLoader(),
                new ValueLoader()
        ));
        var resolvers = Set.of(new IntegerResolver(),
                new StringResolver());
        return new PotatoInterpreter(root, resolvers);
    }
}
