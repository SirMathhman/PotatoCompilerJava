package com.meti.pipeline;

import com.meti.PotatoTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReturnTest extends PotatoTest  {
	@Test
	void test() {
		assertEquals("function a0(){return 10;}", compile("test={return 10;}"));
	}

	@Test
	void testWithHeader(){
		assertEquals("function a0(){return \"Hello World!\";}", compile("test?string={return \"Hello World!\";}"));
	}
}
