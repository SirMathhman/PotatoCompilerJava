package com.meti.command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

class BuildSystem {
    public static final BuildSystem INSTANCE = new BuildSystem();
    public static final Path DEFAULT_TEST = Paths.get("src", "test", "tato");
    public static final Path DEFAULT_OUT = Paths.get("out", "tato");
    public static final Path DEFAULT_SRC = Paths.get("src", "main", "tato");
    private static final Path DEFAULT_PATH = Paths.get(".build");

    public BuildState load() throws IOException {
        Properties properties = new Properties();
        try (var reader = Files.newBufferedReader(DEFAULT_PATH)) {
            properties.load(reader);
        }
        return new BuildState(Paths.get(properties.getProperty("srcDir")),
                Paths.get(properties.getProperty("testDir")),
                Paths.get(properties.getProperty("outDir")));
    }

    public void generate() throws IOException {
        Properties properties = new Properties();
        properties.put("srcDir", DEFAULT_SRC.toString());
        properties.put("testDir", DEFAULT_TEST.toString());
        properties.put("outDir", DEFAULT_OUT.toString());
        try (var writer = Files.newBufferedWriter(DEFAULT_PATH)) {
            properties.store(writer, "");
        }
    }
}
