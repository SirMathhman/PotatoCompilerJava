package com.meti.pipeline;

import com.meti.PotatoTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionTest extends PotatoTest {
	@Test
	void test() {
		assertEquals("function a0(){}", compile("empty={}"));
	}
}
