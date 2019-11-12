package com.meti.command.build;

public interface BuildState<T> {
	T getOut();

	T getSrc();

	T getTest();
}
