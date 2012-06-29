package net.vidageek.regex.token;

import net.vidageek.regex.RegexToken;

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

}
