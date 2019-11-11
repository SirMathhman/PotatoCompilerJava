package com.meti.interpret;

import java.util.List;

public interface Function extends Statement {
	String name();

	List<Function> subFunctions();
}
