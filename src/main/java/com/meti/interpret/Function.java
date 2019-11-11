package com.meti.interpret;

import java.util.List;
import java.util.Set;

public interface Function extends Statement {
	String name();

	List<Function> subFunctions();
}
