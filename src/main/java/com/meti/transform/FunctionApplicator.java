package com.meti.transform;

import com.meti.interpret.statement.*;
import com.meti.interpret.type.AnyType;
import com.meti.interpret.type.ArrayType;
import com.meti.interpret.type.InlineType;
import com.meti.interpret.type.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class FunctionApplicator implements Applicator {
    @Override
    public boolean canApply(Statement statement) {
        return statement instanceof Function;
    }

    private final List<String> depth = new ArrayList<>();
    private final List<Type> types = new ArrayList<>();

    @Override
    public Statement apply(Statement statement, Transformer transformer) {
        var function = (Function) statement;
        var toReturn = function;
        depth.add(function.name());
        if(function.returnType().isEmpty()){
            types.add(new InlineType(depth.toArray(String[]::new)));
            var params = function.parameters()
                    .keySet()
                    .stream()
                    .map(InlineStatement::new)
                    .collect(Collectors.toList());
            var content = List.<Statement>of(new ReturnStatement(new ContentArray(params)));
            toReturn = new InlineFunction(
                    function.name(),
                    new HashSet<>(),
                    function.parameters(),
                    new ArrayType(AnyType.INSTANCE),
                    content,
                    new ArrayList<>());
            for (var subFunction : function.subFunctions()) {
                var appliedSubFunction = (Function) apply(statement, transformer);
                var subContent = subFunction.content();
                var functionToAdd = new InlineFunction(
                        appliedSubFunction.name(),
                        new HashSet<>(),
                        function.parameters(),
                        subFunction.returnType().orElseThrow(),
                        subContent,
                        new ArrayList<>());
                transformer.functions().add(functionToAdd);
            }
        }
        depth.remove(function.name());
        return toReturn;
    }
}
