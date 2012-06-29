package net.vidageek.regex.token;

import java.util.Collections;
import java.util.List;

import net.vidageek.regex.RegexToken;

/**
 * Represents a group of chars, e.g. [agpz]
 * 
 * @author matthaeus
 * 
 */
final public class CharGroupToken implements RegexToken {

    private final List<RegexToken> tokens;

    public CharGroupToken(final List<RegexToken> tokens) {
		Collections.sort( tokens );
		this.tokens = tokens;
    }

    public String getWord() {
		// return just the simplest case, i.e. the first token
		return tokens.get( 0 ).getWord();
    }

	@Override
	public String toString() {
		return tokens + "";
	}

	public int compareTo( RegexToken o ) {
		return getWord().compareTo( o.getWord() );
	}

}
