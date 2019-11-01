package com.meti;

import java.util.List;

public interface AssemblyNode {
	List<? extends AssemblyNode> children();
}
