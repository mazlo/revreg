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

	public List<RegexToken> getTokens() {
		// this char group token always wraps one other object
		if ( tokens.size() > 0 )
			// TODO would be nicer if there wouldn't be programm logic here,
			// wouldn't it?!
			if ( tokens.get( 0 ) instanceof SimpleCharSetToken )
				return tokens.get( 0 ).getTokens();

		// this char group token always wraps one other object
		return tokens;
	}

}
