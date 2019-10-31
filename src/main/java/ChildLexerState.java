import java.util.Optional;

class ChildLexerState implements LexerState {
    private final LexerState parent;
    private final Lexeme value;

    ChildLexerState(LexerState parent, Lexeme value) {
        this.parent = parent;
        this.value = value;
    }

    @Override
    public Optional<LexerState> parent() {
        return Optional.of(parent);
    }

    @Override
    public Optional<Lexeme> value() {
        return Optional.of(value);
    }
}
