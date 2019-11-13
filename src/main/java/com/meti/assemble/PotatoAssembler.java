package com.meti.assemble;

import com.meti.assemble.pattern.*;

import java.util.List;

public final class PotatoAssembler extends PatternAssembler {
    public static final Assembler INSTANCE = build();

    private PotatoAssembler(List<? extends Pattern> patterns) {
        super(patterns);
    }

    private static Assembler build() {
        return new PotatoAssembler(List.of(
                new ReturnPattern(),
                new ContentArrayPattern(),
                new ArrayIndexPattern(),
                new AssignmentPattern(),
                new InvocationPattern(),
                new FunctionPattern(),
                new OperatorPattern(),
                new VariablePattern(),
                new BooleanPattern(),
                new IntegerPattern(),
                new IfElsePattern(),
				new StringPattern(),
                new IfPattern()
        ));
    }
}
