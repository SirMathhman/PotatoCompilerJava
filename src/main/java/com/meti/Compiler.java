package com.meti;

import com.scalified.tree.TreeNode;

import java.util.function.Function;

public interface Compiler extends Function<TreeNode<Statement>, String> {
}
