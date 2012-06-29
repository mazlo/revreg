package net.vidageek.regex.token;

import java.util.Collections;
import java.util.List;

import net.vidageek.regex.RegexToken;

public class CharGroupQuantifierToken implements RegexToken {

	private final List<RegexToken> tokens;

	public CharGroupQuantifierToken(List<RegexToken> tokens) {
		Collections.sort( tokens );
		this.tokens = tokens;
	}

	public int compareTo( RegexToken other ) {
		return getWord().compareTo( other.getWord() );
	}

	public String getWord() {
		StringBuilder builder = new StringBuilder();

		// create a "word" for every token that was added to the list. this is the quantification
		for ( RegexToken regexToken : tokens ) {
			builder.append( regexToken.getWord() );
		}

		return builder.toString();
	}

}
