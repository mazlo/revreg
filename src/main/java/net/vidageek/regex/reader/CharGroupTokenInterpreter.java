package net.vidageek.regex.reader;

import java.util.List;

import net.vidageek.regex.RegexTokenizer;
import net.vidageek.regex.TokenInterpreter;
import net.vidageek.regex.token.CharGroupToken;

final public class CharGroupTokenInterpreter implements TokenInterpreter {

    private final RegexTokenizer tokenizer;

    public CharGroupTokenInterpreter(final List<TokenInterpreter> readers) {
        tokenizer = new RegexTokenizer(readers);
    }

    public boolean accept(final String regex) {
		return regex.charAt( 0 ) == '[' && regex.charAt( regex.length() - 1 ) != '}';
    }

    public RegexPartData interpret(final String regex) {
        String subRegex = regex.substring(1, regex.indexOf(']'));
        CharGroupToken token = new CharGroupToken(tokenizer.tokenize(subRegex));

        return new RegexPartData(token, subRegex.length() + 2);
    }

}
