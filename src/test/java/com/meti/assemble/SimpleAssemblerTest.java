package com.meti.assemble;

import com.meti.lexeme.PotatoLexer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleAssemblerTest {
    @Test
    void assembleSingle() {
        var lexer = PotatoLexer.PotatoLexer;
        var assembler = new SimpleAssembler(List.of(new BlockRecognizer()));
        var lexemes = lexer.parse("extern print[value string]");
        var actualRoot = assembler.assembleChildren(lexemes);

        AssemblyNode print = new SimpleBlockNodeBuilder()
                .setName("print")
                .setModifiers(Set.of(Modifier.EXTERN))
                .setParameters(Map.of("value", Primitive.STRING))
                .build();
        assertEquals(print, actualRoot.get(0));
    }

    @Test
    void assemble() {
        var lexer = PotatoLexer.PotatoLexer;
        var assembler = new SimpleAssembler(List.of(new BlockRecognizer()));
        var lexemes = lexer.parse("single Internal={extern print[value string]}");
        var actualRoot = assembler.assembleSingle(lexemes);

        AssemblyNode print = new SimpleBlockNodeBuilder()
                .setName("print")
                .setModifiers(Set.of(Modifier.EXTERN))
                .setParameters(Map.of("value", Primitive.STRING))
                .build();
        AssemblyNode internal = new SimpleBlockNodeBuilder()
                .setName("Internal")
                .setModifiers(Set.of(Modifier.SINGLE))
                .setChildren(singletonList(print))
                .build();
        var expectedRoot = new GroupNode(singletonList(internal));
        assertEquals(expectedRoot, actualRoot);
    }
}