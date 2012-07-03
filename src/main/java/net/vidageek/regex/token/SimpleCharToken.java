package net.vidageek.regex.token;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.regex.RegexToken;

/**
 * Represents a simple char token in a regular expression, e.g. the letter
 * <i>a</i> or the symbol <i>,</i>.
 * 
 * @author matthaeus
 * 
 */
final public class SimpleCharToken implements RegexToken {

    private final char c;

    public SimpleCharToken(final char c) {
        this.c = c;
    }

    public String getWord() {
		return Character.toString( c ).toLowerCase();
    }

	@Override
	public String toString() {
		return Character.toString( c );
	}

	public int compareTo( RegexToken o ) {
		return getWord().compareTo( o.getWord() );
	}

	public List<RegexToken> getTokens() {
		List<RegexToken> tokens = new ArrayList<RegexToken>();
		tokens.add( this );

		return tokens;
	}

}
