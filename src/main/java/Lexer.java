import java.util.Collection;

interface Lexer {
    Collection<? extends Lexeme> parse(String value);
}
