package com.meti.assemble;

import com.meti.lexeme.match.BlockMatch;
import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AssemblerState {
    private final List<? extends Match> matches;
    private final Assembler assembler;

    public AssemblerState(List<? extends Match> matches, Assembler assembler) {
        this.matches = matches;
        this.assembler = assembler;
    }

    public Assembler parent(){
        return assembler;
    }

    public List<? extends Match> matches() {
        return matches;
    }

    public boolean endsWith(BlockMatch match) {
        return false;
    }

    public Optional<Integer> indexOf(Class<? extends Match> clazz) {
        for (int i = 0, matchesSize = matches.size(); i < matchesSize; i++) {
            if (matches.get(i).getClass().equals(clazz)) return Optional.of(i);
        }
        return Optional.empty();
    }

    public List<? extends Match> sub(int from, int to) {
        return matches.subList(from, to);
    }

    public List<? extends Match> sub(int index) {
        return matches.subList(index, matches.size());
    }

    public <T extends Match> T get(int index, Class<? extends T> clazz) {
        return clazz.cast(matches.get(index));
    }

    public <T> List<T> sub(int from, int to, Class<? extends T> clazz) {
        return matches.subList(from, to).stream()
                .map(clazz::cast)
                .collect(Collectors.toList());
    }
}
