package com.meti.transform;

import com.meti.interpret.statement.Statement;

import java.util.ArrayList;
import java.util.List;

class ApplicatorTransformer implements Transformer {
    private final List<? extends Applicator> applicators;
    private final List<Statement> functions = new ArrayList<>();

    ApplicatorTransformer(List<? extends Applicator> applicators) {
        this.applicators = applicators;
    }

    @Override
    public List<Statement> functions() {
        return functions;
    }

    @Override
    public Statement transform(Statement other) {
        return applicators.stream()
                .filter(app -> app.canApply(other))
                .map(app -> app.apply(other, this))
                .findAny()
                .orElse(other);
    }
}
