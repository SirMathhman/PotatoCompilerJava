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
    void assemble() {
        var lexer = PotatoLexer.PotatoLexer;
        var assembler = new SimpleAssembler(List.of(new BlockRecognizer()));
        var lexemes = lexer.parse("single Internal={extern print[string value]}");
        var root = assembler.assemble(lexemes);

        var print = new BlockNodeBuilder()
                .withName("print")
                .withModifiers(Set.of(Modifier.EXTERN))
                .withArguments(Map.of(Primitive.STRING, "value"))
                .build();
        var internal = new BlockNodeBuilder()
                .withName("Internal")
                .withModifiers(Set.of(Modifier.SINGLE))
                .withChildren(singletonList(print))
                .build();
        assertEquals(internal, root);
    }
}