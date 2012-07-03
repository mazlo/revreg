package net.vidageek.regex.token;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.regex.RegexToken;

public class ShortSimpleCharToken implements RegexToken {

	private final String s;

	public ShortSimpleCharToken(final String s) {
		this.s = s;
	}
	
	public int compareTo( RegexToken o ) {
		return getWord().compareTo( o.getWord() );
	}


    public String getWord() {
		return s.toLowerCase();
    }

	@Override
	public String toString() {
		return s.toString();
	}

	public List<RegexToken> getTokens() {
		List<RegexToken> tokens = new ArrayList<RegexToken>();
		tokens.add( this );

		return tokens;
	}

}
