package com.meti.assemble.bucket;

import com.meti.lex.token.Token;

import java.util.List;

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

    private void advance(Token<?> token) {
        counter++;
        if (counter == buckets.size()) {
            throw new IllegalStateException("Failed to find a matching " +
                    "pattern for " + token);
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
}
