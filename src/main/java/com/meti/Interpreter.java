package com.meti;

import com.scalified.tree.TreeNode;

import java.util.Map;
import java.util.function.Function;

public interface Interpreter extends Function<TreeNode<Map<NodeProperty, Object>>, TreeNode<Statement>> {
}
