package com.meti.assemble;

import com.meti.token.Token;

interface BucketManager {
    boolean add(Token<?> token);

    void reset();
}
