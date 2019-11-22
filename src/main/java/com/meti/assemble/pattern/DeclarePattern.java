package com.meti.assemble.pattern;

import com.meti.lex.token.Operator;
import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.DeclareNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;

import java.util.Optional;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.by;
import static com.meti.assemble.bucket.PredicateBucket.valueEquals;
import static com.meti.assemble.bucket.TypePredicate.any;
import static com.meti.assemble.bucket.TypePredicate.type;
import static com.meti.lex.token.TokenType.*;

public class DeclarePattern implements Pattern {
    private final Bucket declare = by(type(DECLARE), count(1));
    private final Bucket nameBucket = by(type(CONTENT), count(1));
    private final Bucket operator = by(type(OPERATOR), count(1), valueEquals(Operator.ASSIGN));
    private final Bucket value = by(any());

    private final BucketManager manager = new QueuedBucketManager(
            declare, nameBucket, operator, value
    );

    @Override
    public Optional<Node> collect(Assembler assembler) {
        if (declare.present() && nameBucket.present() && value.present()) {
            var mutable = declare.single().valueAs(Boolean.class);
            var name = nameBucket.single().valueAs(String.class);
            var valueNode = assembler.copy().assemble(value.content());
            manager.reset();
            return Optional.of(new DeclareNode(mutable, name, valueNode));
        } else return Optional.empty();
    }

    @Override
    public Pattern form(Token<?> next) {
        manager.add(next);
        return this;
    }

    @Override
    public Pattern copy() {
        return new DeclarePattern();
    }
}
