package com.meti.transform;

import java.util.List;

public class PotatoTransformer extends ApplicatorTransformer {
    public static final Transformer INSTANCE = init();

    private PotatoTransformer(List<? extends Applicator> applicators) {
        super(applicators);
    }

    private static Transformer init() {
        return new PotatoTransformer(List.of(new FunctionApplicator()));
    }
}
