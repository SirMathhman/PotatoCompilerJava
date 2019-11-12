package com.meti.util;

public interface Tryable<R> {
	R execute() throws Exception;
}
