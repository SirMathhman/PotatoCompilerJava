package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.format.SeparatorMatch;
import com.meti.lexeme.match.struct.ArgumentMatch;
import com.meti.lexeme.match.struct.BlockMatch;
import com.meti.lexeme.match.struct.ChildMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class InvocationPattern implements Pattern {
    @Override
    public boolean canAssemble(AssemblyState state) {
        if (state.has(BlockMatch.class)) return false;
        var contentIndex = state.last(ContentMatch.class);
        var argIndex = state.first(ArgumentMatch.class);
        return contentIndex.isPresent() && argIndex.isPresent() &&
                (argIndex.getAsInt() == contentIndex.getAsInt() + 1) &&
                state.get(argIndex.getAsInt(), ArgumentMatch.class).value() &&
                state.has(state.size() - 1, ArgumentMatch.class) &&
                !state.get(state.size() - 1, ArgumentMatch.class).value();
    }

    @Override
    public AssemblyNode assemble(AssemblyState state) {
        var firstIndex = state.first(ArgumentMatch.class);
        var content = state.sub(0, firstIndex.orElseThrow());
        var caller = content.splitByMatch(ChildMatch.class, ContentMatch.class)
                .stream()
                .map(match -> match.get(0))
                .map(ContentMatch::value)
                .collect(Collectors.toList());
        List<AssemblyNode> matches;
        if (state.has(state.size() - 2, ArgumentMatch.class)) {
            matches = new ArrayList<>();
        } else {
            var sub = state.sub(firstIndex.getAsInt() + 1, state.size() - 1);
            matches = sub.split(SeparatorMatch.class)
                    .stream()
                    .map(AssemblyState::assemble)
                    .collect(Collectors.toList());
		}
        return new InlineInvocationNode(caller, matches);
    }
}
