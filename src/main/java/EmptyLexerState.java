import java.util.Optional;

class EmptyLexerState implements LexerState {
    private final String value;
    private final String subValue;
    private final int index;

    EmptyLexerState(String value) {
        this(value, value.substring(0, 1), 0);
    }

    private EmptyLexerState(String value, String subValue, int index) {
        this.value = value;
        this.subValue = subValue;
        this.index = index;
    }

    @Override
    public Optional<LexerState> parent() {
        return Optional.empty();
    }

    @Override
    public Optional<Lexeme> value() {
        return Optional.empty();
    }
}
