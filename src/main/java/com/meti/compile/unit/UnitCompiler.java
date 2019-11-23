package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.Generator;
import com.meti.compile.SimpleGenerator;
import com.meti.interpret.statement.Statement;

import java.util.Set;

public class UnitCompiler implements Compiler {
	private final Generator generator;
	private final Set<? extends Unit> units;

	public UnitCompiler(Unit... units) {
		this(Set.of(units));
	}

	public UnitCompiler(Set<? extends Unit> units) {
		this(units, new SimpleGenerator());
	}

	public UnitCompiler(Set<? extends Unit> units, Generator generator) {
		this.units = units;
		this.generator = generator;
	}

	@Override
	public String compile(Statement statement) {
		return units.stream()
				.filter(unit -> unit.canCompile(statement))
				.map(unit -> unit.compile(statement, this))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException("Failed to locate compilation unit for " + statement));
	}

	@Override
	public Generator generator() {
		return generator;
	}
}
