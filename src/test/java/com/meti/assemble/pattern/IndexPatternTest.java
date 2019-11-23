package com.meti.assemble.pattern;

import com.meti.assemble.node.IndexNode;
import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.VariableNode;
import com.meti.lex.token.InlineToken;
import org.junit.jupiter.api.Test;

import static com.meti.lex.token.TokenType.*;
import static org.junit.jupiter.api.Assertions.*;

class IndexPatternTest {

	@Test
	void collect() {
		var node = new IndexPattern()
				.form(new InlineToken<>(CONTENT, "name"))
				.form(new InlineToken<>(LIST, true))
				.form(new InlineToken<>(INT, 10))
				.form(new InlineToken<>(LIST, false))
				.collect(new PatternAssembler(new IntPattern(), new VariablePattern()))
				.orElseThrow();
		var arrayIndex = (IndexNode) node;
		var array = (VariableNode) arrayIndex.name();
		assertEquals("name", array.name());
		var index =  (IntNode) arrayIndex.index();
		assertEquals(10, index.value());
	}
}