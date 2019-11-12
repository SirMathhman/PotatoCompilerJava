package com.meti.command;

import com.meti.assemble.Assembler;
import com.meti.assemble.AssemblyState;
import com.meti.assemble.ListAssemblyState;
import com.meti.assemble.PotatoAssembler;
import com.meti.console.Evaluator;
import com.meti.interpret.Interpreter;
import com.meti.interpret.PotatoInterpreter;
import com.meti.lexeme.Lexer;
import com.meti.lexeme.PotatoLexer;
import com.meti.lexeme.match.struct.EndLineMatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class InterpretEvaluator implements Evaluator {
    public static final Lexer LEXER = PotatoLexer.INSTANCE;
    public static final Assembler ASSEMBLER = PotatoAssembler.INSTANCE;
    public static final Interpreter INTERPRETER = PotatoInterpreter.INSTANCE;

    @Override
    public String evaluate(String value) {
        var space = value.indexOf(' ');
        String type = space == -1 ? value : value.substring(0, space);
        if (value.isBlank()) {
            return "Nothing was entered to lexise.";
        }
        switch (type) {
            case "string":
                loadString(value.substring(space + 1));
                break;
            case "path":
                loadPath(Paths.get("", value.substring(space + 1).split(" ")));
                break;
            case "build":
                try {
                    var state = BuildSystem.INSTANCE.load();
                    readDirectory(state.getSrc());
                    readDirectory(state.getTest());
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
                break;
            default:
                return "Unknown type: \"" + type + "\"";
        }
        return "Successfully loaded in code.";
    }

    private void readDirectory(Path src) throws IOException {
        Files.walk(src).filter(Files::isRegularFile)
                .forEach(this::loadPath);
    }

    private void loadPath(Path path) {
        try {
            if (!Files.exists(path)) {
                throw new IllegalStateException("Could not find path: \"" + path.toAbsolutePath() + "\"");
            }
            String content;
            try (var reader = Files.newBufferedReader(path)) {
                content = reader.lines().collect(Collectors.joining("\n"));
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }

            var formattedContent = content.replace("\n", "").replace("\t", "");
            loadString(formattedContent);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("Failed to parse path: " + path.toString(), e);
        }
    }

    private void loadString(String formattedContent) {
        var matches = LEXER.parse(formattedContent);
        var state = new ListAssemblyState(matches, ASSEMBLER);
        var splitStates = state.split(EndLineMatch.class, match -> match.value().equals(state.depth()));
        splitStates.forEach((Consumer<AssemblyState>) splitState -> {
            var node = splitState.assemble();
            INTERPRETER.load(node);
        });
    }
}
