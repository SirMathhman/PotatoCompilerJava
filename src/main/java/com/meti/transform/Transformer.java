package com.meti.transform;

import com.meti.interpret.statement.Statement;

public interface Transformer {
	Statement transform(Statement statement);
}
