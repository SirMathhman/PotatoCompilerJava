package com.meti.assemble;

import com.meti.Operator;
import com.meti.token.Token;

import java.util.Optional;

import static com.meti.assemble.CountPredicate.count;
import static com.meti.assemble.PredicateBucket.by;
import static com.meti.assemble.PredicateBucket.equalsType;
import static com.meti.assemble.TypePredicate.any;
import static com.meti.assemble.TypePredicate.type;
import static com.meti.token.TokenType.*;

class DeclarationPattern implements Pattern {
    private final Bucket declare = by(type(DECLARE), count(1));
    private final Bucket nameBucket = by(type(CONTENT), count(1));
    private final Bucket operator = by(type(OPERATOR), count(1), equalsType(Operator.ASSIGN));
    private final Bucket value = by(any());

    private final BucketManager manager = new QueuedBucketManager(
            declare, nameBucket, operator, value
    );

    @Override
    public Optional<Node> form(Token<?> next, Assembler assembler) {
        var wasAdded = manager.add(next);
        if (wasAdded) {
            var mutable = declare.single().valueAs(Boolean.class);
            var name = nameBucket.single().valueAs(String.class);
            var valueNode = assembler.assemble(value.content());
            manager.reset();
            return Optional.of(new DeclarationNode(mutable, name, valueNode));
        } else return Optional.empty();
    }
}
