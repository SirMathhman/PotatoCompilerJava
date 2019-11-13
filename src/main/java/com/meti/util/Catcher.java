package com.meti.util;

public interface Catcher {
    static Catcher create() {
        return new CatcherImpl();
    }

    <R> R evaluate(Tryable<? extends R> tryable, R other);

    class CatcherImpl implements Catcher {
        @Override
        public <R> R evaluate(Tryable<? extends R> tryable, R other) {
            try {
                return tryable.execute();
            } catch (Exception e) {
                return other;
            }
        }
    }
}
