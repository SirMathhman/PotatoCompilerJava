package com.meti.lexeme.match;

import java.util.Map;

public interface MapMatch<A, B> extends Match {
    Map<A, B> map();
}
