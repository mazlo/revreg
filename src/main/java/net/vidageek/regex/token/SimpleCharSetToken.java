package net.vidageek.regex.token;

import java.util.Collections;
import java.util.List;

import net.vidageek.regex.RegexToken;

public class SimpleCharSetToken implements RegexToken {

	private final List<RegexToken> tokens;

	public SimpleCharSetToken(List<RegexToken> tokens) {
		Collections.sort( tokens );
		this.tokens = tokens;
	}

	public String getWord() {
		// return just the simplest case, i.e. the first token
		return tokens.get( 0 ).getWord();
	}

	public int compareTo( RegexToken o ) {
		return getWord().compareTo( o.getWord() );
	}

	public List<RegexToken> getTokens() {
		return tokens;
	}

}
