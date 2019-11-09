package com.meti;

interface Tryable<R> {
	R execute() throws Exception;
}
