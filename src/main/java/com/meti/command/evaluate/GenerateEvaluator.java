package com.meti.command.evaluate;

import com.meti.command.build.BuildSystem;
import com.meti.console.Evaluator;

import java.io.IOException;
import java.nio.file.Files;

public class GenerateEvaluator implements Evaluator {
    @Override
    public String evaluate(String value) {
        try {
            BuildSystem.INSTANCE.generate();
            if (!Files.exists(BuildSystem.DEFAULT_SRC)) Files.createDirectories(BuildSystem.DEFAULT_SRC);
            if (!Files.exists(BuildSystem.DEFAULT_TEST)) Files.createDirectories(BuildSystem.DEFAULT_TEST);
            if (!Files.exists(BuildSystem.DEFAULT_OUT)) Files.createDirectories(BuildSystem.DEFAULT_OUT);
            return "Created build file.";
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
