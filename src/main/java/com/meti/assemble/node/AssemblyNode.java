package com.meti.assemble.node;

public interface AssemblyNode {
	default String format() {
		return toString().replace("\t", "\t\t");
	}
}
