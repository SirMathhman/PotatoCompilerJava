package com.meti;

import com.scalified.tree.TreeNode;

import java.util.function.Function;

public interface Transformer extends Function<TreeNode<Statement>, TreeNode<Statement>> {
}
