package com.meti.assemble;

import com.meti.token.Token;

import java.util.List;

class QueuedBucketManager implements BucketManager {
    private final List<? extends Bucket> buckets;
    private int counter = 0;
    private Bucket current;

    QueuedBucketManager(Bucket... buckets) {
        this(List.of(buckets));
    }

    private QueuedBucketManager(List<? extends Bucket> buckets) {
        if (buckets.isEmpty()) throw new IllegalArgumentException(buckets + "cannot be empty.");
        this.buckets = buckets;
        this.current = buckets.get(0);
    }

    private boolean advance(Token<?> token) {
        counter++;
        if (counter == buckets.size()) {
            throw new IllegalStateException("Failed to find a matching " +
                    "pattern for " + token);
        }
        current = buckets.get(counter);
        return add(token);
    }

    @Override
    public boolean add(Token<?> token) {
        return current.add(token) || advance(token);
    }

    @Override
    public void reset() {
        buckets.forEach(Bucket::empty);
        counter = 0;
        current = buckets.get(0);
    }
}
