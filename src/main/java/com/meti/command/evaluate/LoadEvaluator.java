package com.meti.command.evaluate;

import com.meti.command.build.BuildSystem;
import com.meti.console.Evaluator;

import java.io.IOException;

public class LoadEvaluator implements Evaluator {
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
