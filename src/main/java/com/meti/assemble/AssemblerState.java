package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.Optional;

interface AssemblerState {
    List<Integer> indices(Class<? extends Match> clazz);

    Assembler assembler();

    Optional<Integer> indexOf(Class<? extends Match> clazz);

    List<? extends Match> sub(int from, int to);

    <T extends Match> T get(int index, Class<? extends T> clazz);

    <T> List<T> sub(int from, int to, Class<? extends T> clazz);

    boolean isType(int index, Class<?> clazz);

    int size();

    default boolean contains(Class<? extends Match> clazz) {
        var classIndex = indexOf(clazz);
        return classIndex.isPresent();
    }
}
