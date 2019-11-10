package com.meti.assemble;

public interface AssemblyNode {
	default String format() {
		return toString().replace("\t", "\t\t");
	}
}
