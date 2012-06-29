package net.vidageek.regex.reader;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.regex.Constants;
import net.vidageek.regex.RegexToken;
import net.vidageek.regex.RegexTokenizer;
import net.vidageek.regex.TokenInterpreter;
import net.vidageek.regex.token.SimpleCharSetToken;
import net.vidageek.regex.token.SimpleCharToken;

public class SimpleCharSetTokenInterpreter implements TokenInterpreter {

	private RegexTokenizer tokenizer;

	public SimpleCharSetTokenInterpreter(RegexTokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public boolean accept( String regex ) {
		// do not match quantifier statements
		if ( regex.indexOf( "{" ) > 0 )
			return false;

		// match set statements, e.g. 0-9
		if ( regex.contains( "-" ) )
			return true;

		return false;
	}

	public RegexPartData interpret( String regex ) {

		List<RegexToken> prefixTokens = new ArrayList<RegexToken>();

		// extract the substring
		String subRegex = regex.substring( 0, regex.indexOf( "-" ) + 2 );

		// extract the ranges
		String[] range = subRegex.split( "-" );
		char first = range[0].charAt( 0 );
		char last = range[1].charAt( 0 );

		boolean began = false;
		for ( int i = 0; i < Constants.letters.size(); i++ ) {
			// add chars from the first match to the last match
			if ( !began )
				if ( Constants.letters.get( i ) == first ) {
					began = true;

					prefixTokens.add( new SimpleCharToken( Constants.letters.get( i ) ) );
					continue;
				}

			prefixTokens.add( new SimpleCharToken( Constants.letters.get( i ) ) );

			if ( Constants.letters.get( i ) == last )
				break;

		}

		// recursive tokenization, since there might be another statement after the char set definition, e.g. a-zA-Z
		List<RegexToken> postfixTokens = tokenizer.tokenize( regex.substring( regex.indexOf( "-" ) + 2, regex.length() ) );
		prefixTokens.addAll( postfixTokens );

		SimpleCharSetToken token = new SimpleCharSetToken( prefixTokens );

		return new RegexPartData( token, regex.length() );
	}

}
