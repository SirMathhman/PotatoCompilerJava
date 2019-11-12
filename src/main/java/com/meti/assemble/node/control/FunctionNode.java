package com.meti.assemble.node.control;

import com.meti.assemble.node.AssemblyNode;
import com.meti.lexeme.match.struct.Keyword;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface FunctionNode extends AssemblyNode {
	Optional<String> returnType();

	List<AssemblyNode> getContent();

	Set<Keyword> keywords();

	String name();

	Map<String, String> getParameters();

	boolean isAbstract();
}
