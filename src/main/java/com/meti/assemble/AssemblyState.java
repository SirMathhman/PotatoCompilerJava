package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.Predicate;

public interface AssemblyState {
    @Deprecated
    default AssemblyNode assemble(AssemblyState state1) {
        return parent().assemble(state1);
    }

    default AssemblyNode assemble() {
        return parent().assemble(this);
    }

    Assembler parent();

    int depth();

    OptionalInt first(Class<?> clazz);

    <T> OptionalInt first(Class<T> clazz, Predicate<T> predicate);

    default <T> T getFirst(Class<T> clazz) {
        return get(0, clazz);
    }

    <T> T get(int index, Class<T> clazz);

    default <T> T getLast(Class<T> clazz) {
        return get(size() - 1, clazz);
    }

    int size();

    boolean has(Class<?> clazz);

    default boolean hasFirst(Class<?> clazz) {
        return size() > 0 && has(0, clazz);
    }

    boolean has(int index, Class<?> clazz);

    default boolean hasLast(Class<?> clazz) {
        return has(size() - 1, clazz);
    }

    OptionalInt index(int place, Class<?> clazz);

    default boolean isSingle() {
        return size() == 1;
    }

    OptionalInt last(Class<?> clazz);

    void sink();

    List<? extends AssemblyState> split(Class<?> clazz);

    <T> List<? extends AssemblyState> split(Class<T> clazz, Predicate<T> predicate);

    <T extends Match<?>> List<List<T>> splitByMatch(Class<?> clazz, Class<? extends T> contentMatchClass);

    AssemblyState sub(int index);

    AssemblyState sub(int fromInclusive, int toExclusive);

    <T extends Match<?>> List<T> subMatch(int startInclusive, int endExclusive, Class<T> clazz);

    void surface();

    <T> boolean has(Class<T> clazz, Predicate<T> predicate);
}
