import java.util.regex.Pattern;


public class LexemDefenition {
    private LexemType type;
    private Pattern pattern;

    public LexemDefenition(LexemType type, String pattern) {
        this.type = type;
        this.pattern = Pattern.compile(pattern);
    }

    public LexemType getLexemType() {
        return type;
    }

    public Pattern getPattern() {
        return pattern;
    }

}

