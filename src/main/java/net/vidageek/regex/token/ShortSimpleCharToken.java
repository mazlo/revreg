package net.vidageek.regex.token;

import net.vidageek.regex.RegexToken;

public class ShortSimpleCharToken implements RegexToken {

	public ShortSimpleCharToken(final String s) {
		this.s = s;
	}
	
	public int compareTo( RegexToken o ) {
		return getWord().compareTo( o.getWord() );
	}

	private final String s;

    public String getWord() {
		return s.toLowerCase();
    }

	@Override
	public String toString() {
		return s.toString();
	}
}
