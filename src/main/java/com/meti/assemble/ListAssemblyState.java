package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListAssemblyState implements AssemblyState {
    private final Assembler assembler;
    private final List<? extends Match<?>> matches;
    private int depth;

    public ListAssemblyState(List<? extends Match<?>> matches, Assembler assembler) {
        this(matches, assembler, 0);
    }

    public ListAssemblyState(List<? extends Match<?>> matches, Assembler assembler, int depth) {
        this.matches = matches;
        this.assembler = assembler;
        this.depth = depth;
    }

    @Override
    public Assembler parent() {
        return assembler;
    }

    @Override
    public int depth() {
        return depth;
    }

    @Override
    public OptionalInt first(Class<?> clazz) {
        for (int i = 0; i < matches.size(); i++) {
            if (clazz.isAssignableFrom(matches.get(i).getClass())) {
                return OptionalInt.of(i);
            }
        }
        return OptionalInt.empty();
    }

    @Override
    public <T> OptionalInt first(Class<T> clazz, Predicate<T> predicate) {
        for (int i = 0; i < matches.size(); i++) {
            if (clazz.isAssignableFrom(matches.get(i).getClass()) && predicate.test(clazz.cast(matches.get(i)))) {
                return OptionalInt.of(i);
            }
        }
        return OptionalInt.empty();
    }

    @Override
    public <T> T get(int index, Class<T> clazz) {
        return clazz.cast(matches.get(index));
    }

    @Override
    public int size() {
        return matches.size();
    }

    @Override
    public boolean has(Class<?> clazz) {
        return matches.stream()
                .map(Object::getClass)
                .anyMatch(clazz::isAssignableFrom);
    }

    @Override
    public boolean has(int index, Class<?> clazz) {
        return clazz.isAssignableFrom(matches.get(index).getClass());
    }

    @Override
    public OptionalInt index(int place, Class<?> clazz) {
        int count = 0;
        for (int i = 0; i < matches.size(); i++) {
            if (clazz.isInstance(matches.get(i))) {
                if (count == place - 1) {
                    return OptionalInt.of(i);
                }
                count++;
            }
        }
        return OptionalInt.empty();
    }

    @Override
    public OptionalInt last(Class<?> clazz) {
        return index(count(clazz), clazz);
    }

    private int count(Class<?> clazz) {
        return Math.toIntExact(matches.stream()
                .map(Object::getClass)
                .filter(clazz::isAssignableFrom)
                .count());
    }

    @Override
    public void sink() {
        depth++;
    }

    @Override
    public List<? extends AssemblyState> split(Class<?> clazz) {
        List<List<Match<?>>> lists = new ArrayList<>();
        List<Match<?>> subMatches = new ArrayList<>();
        for (Match<?> match : matches) {
            if (clazz.isInstance(match)) {
                if (!subMatches.isEmpty()) lists.add(subMatches);
                subMatches = new ArrayList<>();
            } else {
                subMatches.add(match);
            }
        }
        if (!subMatches.isEmpty()) lists.add(subMatches);
        return lists.stream()
                .map(others -> new ListAssemblyState(others, assembler, depth))
                .collect(Collectors.toList());
    }

    @Override
    public <T> List<? extends AssemblyState> split(Class<T> clazz, Predicate<T> predicate) {
        List<List<Match<?>>> lists = new ArrayList<>();
        List<Match<?>> subMatches = new ArrayList<>();
        for (Match<?> match : matches) {
            if (clazz.isInstance(match) && predicate.test(clazz.cast(match))) {
                if (!subMatches.isEmpty()) lists.add(subMatches);
                subMatches = new ArrayList<>();
            } else {
                subMatches.add(match);
            }
        }
        if (!subMatches.isEmpty()) lists.add(subMatches);
        return lists.stream()
                .map(others -> new ListAssemblyState(others, assembler, depth))
                .collect(Collectors.toList());
    }

    @Override
    public <T extends Match<?>> List<List<T>> splitByMatch(Class<?> clazz, Class<? extends T> contentMatchClass) {
        List<List<T>> lists = new ArrayList<>();
        List<T> subMatches = new ArrayList<>();
        for (Match<?> match : matches) {
            if (clazz.isInstance(match)) {
                lists.add(subMatches);
                subMatches = new ArrayList<>();
            } else {
                subMatches.add(contentMatchClass.cast(match));
            }
        }
        lists.add(subMatches);
        return lists;
    }

    //TODO: merge split algorithms

    @Override
    public AssemblyState sub(int index) {
        return new ListAssemblyState(matches.subList(index, matches.size()), assembler, depth);
    }

    @Override
    public AssemblyState sub(int fromInclusive, int toExclusive) {
        return new ListAssemblyState(matches.subList(fromInclusive, toExclusive), assembler, depth);
    }

    @Override
    public <T extends Match<?>> List<T> subMatch(int startInclusive, int endExclusive, Class<T> clazz) {
        return matches.subList(startInclusive, endExclusive)
                .stream()
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    @Override
    public void surface() {
        depth--;
    }

    @Override
    public <T> boolean has(Class<T> clazz, Predicate<T> predicate) {
        return matches.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .anyMatch(predicate);
    }

    @Override
    public String toString() {
        return "ListAssemblyState{" +
                "matches=" + matches +
                '}';
    }
}
