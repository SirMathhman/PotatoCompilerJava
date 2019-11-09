package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.Optional;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ListAssemblerState implements AssemblerState {
    private final List<? extends Match> matches;
    private final Assembler assembler;

    public ListAssemblerState(List<? extends Match> matches, Assembler assembler) {
        this.matches = matches;
        this.assembler = assembler;
    }

    @Override
    public List<Integer> indices(Class<? extends Match> clazz) {
        return IntStream.range(0, matches.size())
                .filter(value -> matches.get(value).getClass().equals(clazz))
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Assembler parent(){
        return assembler;
    }

    @Override
    public List<? extends Match> matches() {
        return matches;
    }

    @Override
    public Optional<Integer> indexOf(Class<? extends Match> clazz) {
        for (int i = 0, matchesSize = matches.size(); i < matchesSize; i++) {
            if (matches.get(i).getClass().equals(clazz)) return Optional.of(i);
        }
        return Optional.empty();
    }

    @Override
    public List<? extends Match> sub(int from, int to) {
        return matches.subList(from, to);
    }

    @Override
    public List<? extends Match> sub(int index) {
        return matches.subList(index, matches.size());
    }

    @Override
    public <T extends Match> T get(int index, Class<? extends T> clazz) {
        return clazz.cast(matches.get(index));
    }

    @Override
    public <T> List<T> sub(int from, int to, Class<? extends T> clazz) {
        return matches.subList(from, to).stream()
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isType(int index, Class<?> clazz) {
        return matches.get(index).getClass().equals(clazz);
    }

    @Override
    public int size() {
        return matches.size();
    }
}
