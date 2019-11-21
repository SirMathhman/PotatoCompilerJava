package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.Node;
import com.meti.assemble.node.VariableNode;
import com.meti.lex.token.Token;

import java.util.Optional;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.by;

class VariablePattern implements Pattern {
    private final Bucket bucket = by(count(1));
    private final BucketManager manager = new QueuedBucketManager(bucket);

    @Override
    public Optional<Node> collect(Assembler assembler) {
        return bucket.present() ?
                Optional.of(new VariableNode(bucket.single().valueAs(String.class))) :
                Optional.empty();
    }

    @Override
    public Pattern form(Token<?> next) {
        manager.add(next);
        return this;
    }

    @Override
    public Pattern copy() {
        return new VariablePattern();
    }
}
