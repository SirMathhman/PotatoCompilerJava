package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.Optional;
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
	public boolean has(Class<? extends Match> clazz) {
	    return find(clazz).isPresent();
	}

    @Override
    public List<Integer> findAll(Class<? extends Match> clazz) {
        return IntStream.range(0, matches.size())
                .filter(value -> matches.get(value).getClass().equals(clazz))
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Assembler assembler(){
        return assembler;
    }

    @Override
    public Optional<Integer> find(Class<? extends Match> clazz) {
        for (int i = 0, matchesSize = matches.size(); i < matchesSize; i++) {
            if (matches.get(i).getClass().equals(clazz)) return Optional.of(i);
        }
        return Optional.empty();
    }

    @Override
    public List<? extends Match> slice(int from, int to) {
        return matches.subList(from, to);
    }

    @Override
    public <T extends Match> T get(int index, Class<T> clazz) {
        return clazz.cast(matches.get(index));
    }

    @Override
    public <T> List<T> slice(int from, int to, Class<? extends T> clazz) {
        return matches.subList(from, to).stream()
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    @Override
    public boolean has(int index, Class<? extends Match> clazz) {
        return matches.get(index).getClass().equals(clazz);
    }

    @Override
    public int size() {
        return matches.size();
    }
}
