package com.meti;

import java.util.Optional;

public interface Matcher<M> {
	Optional<M> match(String string);
}
