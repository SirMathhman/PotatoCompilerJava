package com.meti.assemble.bucket;

import com.meti.lex.token.Token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class QueuedBucketManager implements BucketManager {
    private final List<? extends Bucket> buckets;
    private int counter = 0;
    private Bucket current;

    public QueuedBucketManager(Bucket... buckets) {
        this(List.of(buckets));
    }

    private QueuedBucketManager(List<? extends Bucket> buckets) {
        if (buckets.isEmpty()) throw new IllegalArgumentException(buckets + "cannot be empty.");
        this.buckets = buckets;
        this.current = buckets.get(0);
    }

    @Override
    public boolean allPresent() {
        return buckets.stream().allMatch(Bucket::present);
    }

    @Override
    public List<? extends Token<?>> at(int index) {
        return buckets.get(index).content();
    }

    @Override
    public <R> R at(int index, Class<R> clazz) {
        return buckets.get(index).single().valueAs(clazz);
    }

    private void advance(Token<?> token) {
        counter++;
        if (counter >= buckets.size()) {
            return;
        }
        current = buckets.get(counter);
        add(token);
    }

    @Override
    public void add(Token<?> token) {
        if (!current.add(token)) {
            advance(token);
        }
    }

    @Override
    public void reset() {
        buckets.forEach(Bucket::empty);
        counter = 0;
        current = buckets.get(0);
    }

    @Override
    public List<? extends List<? extends Token<?>>> split(int index, Predicate<Token<?>> predicate) {
        var list = new ArrayList<List<Token<?>>>();
        var current = new ArrayList<Token<?>>();
        Iterator<? extends Token<?>> iterator = at(index).iterator();
        do {
            Token<?> next = iterator.next();
            if (predicate.test(next)) {
                list.add(current);
                current = new ArrayList<>();
            }
            else {
                current.add(next);
            }
        } while (iterator.hasNext());
        return list;
    }
}
