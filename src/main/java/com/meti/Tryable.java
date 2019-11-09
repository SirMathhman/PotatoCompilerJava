package com.meti;

public interface Tryable<R> {
	R execute() throws Exception;
}
