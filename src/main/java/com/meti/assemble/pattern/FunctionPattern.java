package com.meti.assemble.pattern;

import com.meti.assemble.AssemblyState;
import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.control.InlineFunctionNode;
import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.format.ListMatch;
import com.meti.lexeme.match.format.SeparatorMatch;
import com.meti.lexeme.match.struct.*;

import java.util.*;
import java.util.stream.Collectors;

public class FunctionPattern implements Pattern {
    @Override
    public boolean canAssemble(AssemblyState state) {
        OptionalInt optional;
        if (state.has(OperatorMatch.class, match -> match.value().equals(Operator.RETURN))) {
            var firstEquals = state.first(OperatorMatch.class, match -> match.value().equals(Operator.EQUALS));
            var firstReturn = state.first(OperatorMatch.class, match -> match.value().equals(Operator.RETURN));
            if (firstEquals.isEmpty()) return false;
            if (firstReturn.isEmpty()) return false;
            optional = firstEquals.getAsInt() < firstReturn.getAsInt() ?
                    state.first(OperatorMatch.class) :
                    state.index(2, OperatorMatch.class);
        } else optional = state.first(OperatorMatch.class, match -> match.value().equals(Operator.EQUALS));
        return optional.isPresent() && !state.has(0, VariableMatch.class);
    }

    @Override
    public AssemblyNode assemble(AssemblyState state) {
        var nameIndex = state.first(ContentMatch.class).orElseThrow();
        var name = state.get(nameIndex, ContentMatch.class).value();
        var keywords = parseKeywords(state, nameIndex);
        var genericBounds = parseGenerics(state);
        var paramMap = parseParameters(state);
        var returnType = parseReturnType(state);
        var firstBlockMatch = state.first(BlockMatch.class);
        var isAbstract = firstBlockMatch.isEmpty();
        var content = firstBlockMatch.isEmpty() ?
                new ArrayList<AssemblyNode>() :
                parseContent(state, firstBlockMatch.getAsInt());
        return new InlineFunctionNode(name, keywords, genericBounds, paramMap, returnType, content, isAbstract);
    }

    private Set<Keyword> parseKeywords(AssemblyState state, int nameIndex) {
        return state.subMatch(0, nameIndex, KeywordMatch.class)
                .stream()
                .map(KeywordMatch::value)
                .collect(Collectors.toSet());
    }

    private ArrayList<String> parseGenerics(AssemblyState state) {
        var genericBounds = new ArrayList<String>();
        var lessThanIndex = state.first(OperatorMatch.class, match -> match.value().equals(Operator.LESS_THAN));
        var greaterThanIndex = state.first(OperatorMatch.class, match -> match.value().equals(Operator.GREATER_THAN));
        if (lessThanIndex.isPresent() &&
                greaterThanIndex.isPresent() &&
                lessThanIndex.getAsInt() < greaterThanIndex.getAsInt() &&
                (state.has(greaterThanIndex.getAsInt() + 1, ListMatch.class) ||
                        state.has(greaterThanIndex.getAsInt() + 1, OperatorMatch.class,
                                match -> match.value().equals(Operator.EQUALS)))
        ) {
            genericBounds.addAll(state.sub(lessThanIndex.getAsInt() + 1, greaterThanIndex.getAsInt())
                    .split(SeparatorMatch.class)
                    .stream()
                    .filter(state0 -> state0.size() == 1)
                    .filter(state0 -> state0.has(0, ContentMatch.class))
                    .map(state0 -> state0.get(0, ContentMatch.class))
                    .map(ContentMatch::value)
                    .collect(Collectors.toList()));
        }
        return genericBounds;
    }

    private Map<String, String> parseParameters(AssemblyState state) {
        var paramMap = new HashMap<String, String>();
        var paramStart = state.first(ListMatch.class);
        if (paramStart.isPresent()) {
            var paramEnd = state.index(2, ListMatch.class).orElseThrow();
            var params = state.sub(paramStart.getAsInt() + 1, paramEnd);
            return params.split(SeparatorMatch.class)
                    .stream()
                    .collect(Collectors.toMap(
                            subState -> subState.get(0, ContentMatch.class).value(),
							subState -> subState.get(1, ContentMatch.class).value()));
        }
        return paramMap;
    }

    private String parseReturnType(AssemblyState state) {
        var returnFlag = state.first(OperatorMatch.class, match -> match.value().equals(Operator.RETURN));
        var equalsFlag = state.first(OperatorMatch.class, match -> match.value().equals(Operator.EQUALS));
        String returnType = null;
        if (returnFlag.isPresent() && equalsFlag.isPresent() && returnFlag.getAsInt() < equalsFlag.getAsInt()) {
            var returnTypeMatch = state.get(returnFlag.getAsInt() + 1, ContentMatch.class);
            returnType = returnTypeMatch.value();
        }
        return returnType;
    }

    private List<AssemblyNode> parseContent(AssemblyState state, int blockStartIndex) {
        state.sink();
        var content = state.sub(blockStartIndex + 1, state.size() - 1)
                .split(EndLineMatch.class, endLineMatch -> endLineMatch.value() == state.depth())
                .stream()
                .map(AssemblyState::assemble)
                .collect(Collectors.toList());
        state.surface();
        return content;
    }
}
