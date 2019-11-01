package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.Queue;

class BlockRecognizer implements Recognizer {
    @Override
    public String name() {
        return "function";
    }

    @Override
    public Pattern locate(Queue<? extends Match> matches) {

        return null;
    }
}
