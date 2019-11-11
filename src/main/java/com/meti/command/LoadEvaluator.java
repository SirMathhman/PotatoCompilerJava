package com.meti.command;

import com.meti.console.Evaluator;

import java.io.IOException;

class LoadEvaluator implements Evaluator {
    @Override
    public String evaluate(String value) {
        try {
            BuildSystem.INSTANCE.load();
            return "Loaded build file.";
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
