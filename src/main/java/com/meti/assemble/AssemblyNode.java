package com.meti.assemble;

import java.util.List;

public interface AssemblyNode {
	List<? extends AssemblyNode> children();
}
