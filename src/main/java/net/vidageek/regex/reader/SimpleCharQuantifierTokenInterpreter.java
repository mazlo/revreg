package net.vidageek.regex.reader;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.regex.RegexToken;
import net.vidageek.regex.RegexTokenizer;
import net.vidageek.regex.TokenInterpreter;
import net.vidageek.regex.token.SimpleCharQuantifierToken;
import net.vidageek.regex.token.SimpleCharToken;

public class SimpleCharQuantifierTokenInterpreter implements TokenInterpreter {

	private RegexTokenizer tokenizer;

	public SimpleCharQuantifierTokenInterpreter(RegexTokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	@Override
	public boolean accept( String regex ) {
		// do not match char group tokens
		if ( regex.startsWith( "[" ) )
			return false;

		// do not match set statements, e.g. 0-9
		if ( regex.contains( "-" ) )
			return false;

		if ( regex.startsWith( "\\" ) )
			return false;

		// accept only if quantifier braces are given
		if ( Character.isDefined( regex.charAt( 0 ) ) && regex.indexOf( "{" ) == 1 && regex.indexOf( "}" ) > 0 )
			return true;

		return false;
	}

	@Override
	public RegexPartData interpret( String regex ) {

		// extract the quantifier
		String quantifierString = regex.substring( regex.indexOf( "{" ) + 1, regex.indexOf( "}" ) );

		int min = 0;
		int max = 0;
		if ( quantifierString.contains( "," ) ) {
			// extract max value
			max = Integer.valueOf( quantifierString.split( "," )[0] );
		} else {
			max = Integer.valueOf( quantifierString );
		}

		SimpleCharToken simpleCharToken = new SimpleCharToken( regex.charAt( 0 ) );

		List<RegexToken> tokens = new ArrayList<RegexToken>();
		for ( ; min < max; min++ ) {
			// add the token the number of times it was stated by the group quantifier
			tokens.add( simpleCharToken );
		}

		// the resulting quantifierToken
		SimpleCharQuantifierToken token = new SimpleCharQuantifierToken( tokens );

		// new length is: 2 + 2 for both braces and the length of the quantifierString itself
		return new RegexPartData( token, regex.length() );
	}

}
