package com.meti.command.build;

import java.nio.file.Path;

class PathBuildState implements BuildState<Path> {
	private final Path out;
	private final Path src;
	private final Path test;

	PathBuildState(Path src, Path test, Path out) {
		this.src = src;
		this.test = test;
		this.out = out;
	}

	@Override
	public Path getOut() {
		return out;
	}

	@Override
	public Path getSrc() {
		return src;
	}

	@Override
	public Path getTest() {
		return test;
	}
}
