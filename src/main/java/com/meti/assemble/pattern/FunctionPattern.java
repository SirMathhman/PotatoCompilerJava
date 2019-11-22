package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.bucket.Bucket;
import com.meti.assemble.bucket.BucketManager;
import com.meti.assemble.bucket.QueuedBucketManager;
import com.meti.assemble.node.FunctionNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Operator;
import com.meti.lex.token.Token;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.meti.assemble.bucket.CountPredicate.count;
import static com.meti.assemble.bucket.PredicateBucket.*;
import static com.meti.assemble.bucket.TypePredicate.type;
import static com.meti.lex.token.TokenType.*;
import static java.util.function.Predicate.not;

public class FunctionPattern implements Pattern {
    private final Bucket nameBucket = by(type(CONTENT), count(1));
    private final Bucket parameterStart = by(type(LIST), valueEquals(true));
    private final Bucket parameters = by(not(type(LIST).and(valueEquals(false))));
    private final Bucket parameterEnd = by(type(LIST), valueEquals(false), count(1));
    private final Bucket assignBucket = by(type(OPERATOR), valueEquals(Operator.ASSIGN), count(1));
    private final Bucket contentBucket = byAny();
    private final BucketManager manager = new QueuedBucketManager(
            nameBucket,
            parameterStart,
            parameters,
            parameterEnd,
            assignBucket,
            contentBucket
    );

    @Override
    public Optional<Node> collect(Assembler assembler) {
        if (nameBucket.present() && assignBucket.present() && contentBucket.present()) {
            var name = manager.at(0, String.class);
            var content = assembler.assembleChild(manager.at(2));
            var parameterMap =  manager.split(3, type(ENTRY)).stream()
                    .collect(Collectors.toMap(
                            tokens -> tokens.get(0).valueAs(String.class),
                            tokens -> tokens.get(1).valueAs(String.class)));
            return Optional.of(new FunctionNode(name, parameterMap, content));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Pattern form(Token<?> next) {
        manager.add(next);
        return this;
    }

    @Override
    public Pattern copy() {
        return new FunctionPattern();
    }
}
