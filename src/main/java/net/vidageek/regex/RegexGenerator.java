package net.vidageek.regex;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Regular Expression generator. This class will create the most simple instance
 * of a regular expression. For instance, the regular expression
 * <i>'[0-9]{3}[a-z]'</i> will create a string that look like this
 * <i>'000a'</i>. The resulting string can be seen as a representator for the
 * regular expression.
 * 
 */
final public class RegexGenerator {

    private final String originalRegex;
    private final List<RegexToken> tokens;

    public RegexGenerator(final String regex) {
        if (regex == null) {
            throw new IllegalArgumentException("regex cannot be null");
        }

        try {
			// validates the pattern
            Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("regex " + regex + " is not a valid java regex.");
        }

        originalRegex = regex;
        tokens = new RegexTokenizer().tokenize(regex);
    }

	/**
	 * Returns this original regular expression.
	 * 
	 * @return
	 */
    public String getOriginalRegex() {
        return originalRegex;
    }

	/**
	 * Returns the most simple instance of a regular expression.
	 * 
	 * @return
	 */
    public String generateMatchingWord() {
        String word = "";
        for (RegexToken token : tokens) {
            word += token.getWord();
        }

        return word;
    }

	public static String generateMatchingWord( String regex ) {
		return new RegexGenerator( regex ).generateMatchingWord();
	}

}
