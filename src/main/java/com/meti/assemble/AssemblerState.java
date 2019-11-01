package com.meti.assemble;

import com.meti.lexeme.match.BlockMatch;
import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.Optional;

interface AssemblerState {
    Assembler parent();

    List<? extends Match> matches();

    boolean endsWith(BlockMatch match);

    Optional<Integer> indexOf(Class<? extends Match> clazz);

    List<? extends Match> sub(int from, int to);

    List<? extends Match> sub(int index);

    <T extends Match> T get(int index, Class<? extends T> clazz);

    <T> List<T> sub(int from, int to, Class<? extends T> clazz);

    boolean isType(int index, Class<?> clazz);

    int size();
}
