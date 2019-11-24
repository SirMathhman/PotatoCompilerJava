package com.meti.pipeline;

import com.meti.PotatoTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubFunctionTest extends PotatoTest {
	@Test
	void oneSubFunction() {
		var value = "parent?void={val x = 10;child?void={val y = x;}}";
		var result = compile(value);
		assertEquals("function a0(){var b1=10;return [b1];}function c2(", result);
	}
}
