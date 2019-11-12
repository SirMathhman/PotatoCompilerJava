package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.value.ValueNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.InlineBooleanValue;
import com.meti.interpret.statement.InlineIntegerValue;
import com.meti.interpret.statement.InlineStringValue;
import com.meti.interpret.statement.Statement;

public class ValueLoader implements Loader {
	@Override
	public boolean canLoad(AssemblyNode node) {
		return node instanceof ValueNode;
	}

	@Override
	public Statement load(AssemblyNode node, Interpreter interpreter) {
		var valueNode = (ValueNode<?>) node;
		var value = valueNode.value();
		if (String.class.equals(value.getClass())) return new InlineStringValue((String) value);
		else if (Integer.class.equals(value.getClass())) return new InlineIntegerValue((int) value);
        else if (Boolean.class.equals(value.getClass())) return new InlineBooleanValue((boolean) value);
		throw new IllegalArgumentException("Unknown type: " + value.getClass());
	}
}
