package com.meti.lex.token;

import com.meti.PotatoTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionTokenizeTest extends PotatoTest {
	@Test
	void test() {
		assertEquals("function a0(){}", compile("empty={}"));
	}
}
