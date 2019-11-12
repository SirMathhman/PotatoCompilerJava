package com.meti.command;

import java.nio.file.Path;

class BuildState {
    private final Path src;
    private final Path test;
    private final Path out;

    BuildState(Path src, Path test, Path out) {
        this.src = src;
        this.test = test;
        this.out = out;
    }

    public Path getSrc() {
        return src;
    }

    public Path getTest() {
        return test;
    }

    public Path getOut() {
        return out;
    }
}
