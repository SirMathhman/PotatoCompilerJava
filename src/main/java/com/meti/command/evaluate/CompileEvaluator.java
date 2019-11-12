package com.meti.command.evaluate;

import com.meti.compile.JSPotatoCompiler;
import com.meti.console.Evaluator;
import com.meti.interpret.PotatoInterpreter;
import com.meti.interpret.statement.Statement;
import com.meti.transform.PotatoTransformer;

import java.util.ArrayList;

public class CompileEvaluator implements Evaluator {
    @Override
    public String evaluate(String value) {
        if (value.toLowerCase().equals("js")) {
            var statements = PotatoInterpreter.INSTANCE.statements();
            var compiledStatements = PotatoTransformer.INSTANCE.transform(statements);
            var renderedStatements = new ArrayList<Statement>();
            renderedStatements.addAll(compiledStatements);
            renderedStatements.addAll(PotatoTransformer.INSTANCE.functions());
			return JSPotatoCompiler.INSTANCE.compile(renderedStatements);
        } else {
            return "Unsupported compilation type: \"" + value + "\"";
        }
    }
}
