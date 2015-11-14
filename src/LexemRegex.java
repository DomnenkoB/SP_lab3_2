import java.util.ArrayList;

public class LexemRegex {
    public static String[] Keywords = new String[] {
            "and", "and_eq", "ams", "auto", "bitand", "bitor", "bool",
            "break", "case", "continue", "default", "delete", "do", "double",
            "dynamic_cast", "else", "enum", "explicit", "goto", "if", "inline",
            "int", "long", "mutable", "namespace", "new", "not", "public",
            "register", "reinterpret_cast", "return", "short", "signed", "sizeof", "static",
            "static_cast", "try", "typedef", "typeid", "typename", "union", "unsigned",
            "using", "virtual", "void", "catch", "char", "class", "compl",
            "const", "const_cast", "export", "extern", "false", "float", "for",
            "friend", "not_eq", "operator", "or", "or_eq", "private", "protected",
            "struct", "stwitch", "template", "this", "throw", "true", "volatile",
            "wchar_t", "while", "xor", "xor_eq"
    };

    public static ArrayList<LexemDefenition> Expressions = new ArrayList<LexemDefenition>() {
        {

            this.add(new LexemDefenition(LexemType.Comment,
                    "(?:/\\*[^*]*\\*+(?:[^*/][^*]*\\*+)*/)|(?://.*)"));

            this.add(new LexemDefenition(LexemType.Identifier,
                    "[a-zA-Z_][a-zA-Z0-9_]*"));

            
            this.add(new LexemDefenition(LexemType.Operator,
                    "::|\\.\\*?|->\\*?|\\[|\\]|\\((([a-zA-Z_]*\\))?)|\\)" +
                    "|\\+(\\+|=)?|-[=-]?|~|!=?|&[=&]?|\\*=?|new|delete|sizeof" +
                    "|\\/=?|%=?|<(<=|<|=)?|>(>=|>|=)?|==?|\\^=?" +
                    "|\\|(\\||=)?|\\?|:|,"));

            
            this.add(new LexemDefenition(LexemType.Punctuator,
                    "\\{|\\}|;"));


            this.add(new LexemDefenition(LexemType.Character,
                    "L?\'([^\'\\\\\n]|(\\\\[\'\"\\\\?abfnrtuUxv])|" +
                            "(\\\\[0-7]{1,3})|(\\\\x[0-9a-fA-F]{1,})|" +
                            "(\\\\(u|U)([0-9a-fA-F]{4}){1,2}))*\'"));

            this.add(new LexemDefenition(LexemType.PreprocessingDirective,
                    "#\\s*(define|undef|if|elif|else|ifndef|endif|line|error|ifdef|pragma|import|include|using)"));

            this.add(new LexemDefenition(LexemType.String,
                    "L?\"([^'\\\\\n" +
                    "]|(\\\\['\"\\\\?abfnrtuUxv])|\" +\n" +
                    "(\\\\\\\\[0-7]{1,3})|(\\\\\\\\x[0-9a-fA-F]{1,})|\" +\n" +
                     "(\\\\(u|U)([0-9a-fA-F]{4}){1,2}))*\""));



            this.add(new LexemDefenition(LexemType.Real,
                    "((((([0-9]+\\.[0-9]*)|([0-9]*\\.[0-9]+))([eE][+-]?[0-9]+)?))|" +
                            "([0-9]+[eE][+-]?[0-9]+))[flFL]?"));

            this.add(new LexemDefenition(LexemType.Integer,
                    "((0[0-7]+)|(0[xX][0-9a-bA-F]+)|([0-9]+))(([uU][lL])|([lL][uU])|([uU])|([lL]))?"));


        }
    };

}
