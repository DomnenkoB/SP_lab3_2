
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String path = "input.cpp";
        if (!path.isEmpty()) {

            LexicalParser lexicalParser = new LexicalParser(path);
            ArrayList<Lexem> result = lexicalParser.getResult();

            for (Lexem lexem : result) {
                System.out.println(lexem.getLexemType() + " " + lexem.getLexemValue());
            }
        }

    }
}
