package net.vidageek.regex.token;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.regex.RegexToken;

public class SimpleCharQuantifierToken implements RegexToken {

	private List<RegexToken> tokens = new ArrayList<RegexToken>();

	public SimpleCharQuantifierToken(List<RegexToken> tokens) {
		this.tokens = tokens;
	}

	@Override
	public int compareTo( RegexToken o ) {
		return getWord().compareTo( o.getWord() );
	}

	@Override
	public String getWord() {
		StringBuilder builder = new StringBuilder();

		// create a "word" for every token that was added to the list. this is the quantification
		for ( RegexToken regexToken : tokens ) {
			builder.append( regexToken.getWord() );
		}

		return builder.toString();
	}

	@Override
	public List<RegexToken> getTokens() {
		return tokens;
	}

}
