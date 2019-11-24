package com.meti;

import com.scalified.tree.TreeNode;
import org.javatuples.Pair;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface Assembler extends Function<List<Pair<Token, Object>>, TreeNode<Map<NodeProperty, Object>>> {
}
