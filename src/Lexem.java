
public class Lexem {

    private String value;

    private LexemType type;

    public Lexem(String str, LexemType type) {
        this.value = str;
        this.type = type;
    }

    public String getLexemValue() {
        return value;
    }

    public LexemType getLexemType() {
        return type;
    }

}
