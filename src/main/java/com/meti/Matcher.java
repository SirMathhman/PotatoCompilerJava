package com.meti;

import java.util.Optional;

public interface Matcher<M> {
	Optional<? extends M> match(String string);
}
