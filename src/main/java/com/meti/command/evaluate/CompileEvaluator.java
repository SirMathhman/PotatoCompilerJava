package com.meti.command.evaluate;

import com.meti.compile.JSPotatoCompiler;
import com.meti.console.Evaluator;
import com.meti.interpret.PotatoInterpreter;
import com.meti.transform.PotatoTransformer;

public class CompileEvaluator implements Evaluator {
    @Override
    public String evaluate(String value) {
        if (value.toLowerCase().equals("js")) {
            var statements = PotatoInterpreter.INSTANCE.statements();
            var compiledStatements = PotatoTransformer.INSTANCE.transform(statements);
			return JSPotatoCompiler.INSTANCE.compile(compiledStatements);
        } else {
            return "Unsupported compilation type: \"" + value + "\"";
        }
    }
}
