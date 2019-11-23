package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.BlockUnit;

public class PotatoCompiler extends UnitCompiler {
	public static final Compiler INSTANCE = new PotatoCompiler(
			new AllocUnit(),
			new AssignUnit(),
			new DeclareUnit(),
			new GroupUnit(),
			new IndexUnit(),
			new IntUnit(),
			new OperationUnit(),
			new QuantityUnit(),
			new FunctionUnit(),
			new BlockUnit(),
			new VariableUnit()
	);

	private PotatoCompiler(Unit... units) {
		super(units);
	}
}
