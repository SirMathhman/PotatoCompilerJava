package com.meti.transform;

import com.meti.interpret.statement.Statement;

interface Applicator {
    boolean canApply(Statement statement);

    Statement apply(Statement statement, Transformer transformer);
}
