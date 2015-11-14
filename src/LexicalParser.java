import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class LexicalParser {

    private String text;

    private Path path;

    private ArrayList<Lexem> lexems;

    private int currentPosition;

    public LexicalParser(String _path) {
        path = Paths.get(_path);
        lexems = new ArrayList<Lexem>();
        currentPosition = 0;
    }

    public ArrayList<Lexem> getResult() {
        readFile();
        parse();
        return lexems;
    }

    public void readFile() {
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();

            for (String line : lines) {
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }

            text = stringBuilder.toString().trim();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private boolean inBounds() {
        return currentPosition < text.length();
    }

    private void skipSpaces() {
        while (this.inBounds() &&
                Character.isWhitespace(text.charAt(currentPosition))) {
            ++currentPosition;
        }
    }

    private void parse() {
        while (this.inBounds()) {
            this.skipSpaces();

            if (!this.inBounds()) {
                break;
            }

            Lexem lexem = this.identificationLexem();

            if (lexem == null) {
                int endWord = currentPosition;
                while (endWord < text.length()
                        &&!Character.isWhitespace(text.charAt(endWord))) {
                    endWord++;
                }
                String lexemValue = this.text.substring(this.currentPosition,
                        endWord);

                lexem = new Lexem(lexemValue, LexemType.Unknown);

                this.currentPosition += lexemValue.length();
            }

            this.lexems.add(lexem);
        }
    }



    private Lexem identificationLexem()
    {
        for (LexemDefenition definition : LexemRegex.Expressions)
        {
            String matchString = this.text.substring(this.currentPosition);

            Matcher matcher = definition.getPattern().matcher(
                    matchString);

            if (!matcher.lookingAt())
            {
                continue;
            }

            LexemType lexemType = definition.getLexemType();

            String lexemValue = matchString.substring(0, matcher.end()).trim();

            if (lexemType == LexemType.Identifier && Arrays.asList(LexemRegex.Keywords).contains(lexemValue))
            {
                lexemType = lexemType.Keyword;
            }

            Lexem lexem = new Lexem(lexemValue, lexemType);

            this.currentPosition += lexemValue.length();

            return lexem;
        }

        return null;
    }

}
