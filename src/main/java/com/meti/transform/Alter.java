package com.meti.transform;

import com.meti.interpret.statement.Statement;

import java.util.List;

public interface Alter {
	List<Statement> alter(Statement statement);
}
