package net.vidageek.regex.reader;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.regex.RegexToken;
import net.vidageek.regex.RegexTokenizer;
import net.vidageek.regex.TokenInterpreter;
import net.vidageek.regex.token.CharGroupQuantifierToken;
import net.vidageek.regex.token.CharGroupToken;

public class CharGroupQuantifierTokenInterpreter implements TokenInterpreter {

	private RegexTokenizer tokenizer;

	public CharGroupQuantifierTokenInterpreter(RegexTokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public boolean accept( String regex ) {
		if ( regex.startsWith( "\\" ) )
			// do not match short char sets
			return false;

		// accept only if quantifier braces are given
		if ( regex.indexOf( "{" ) > 0 && regex.indexOf( "}" ) > 0 )
			return true;
		
		return false;
	}

	public RegexPartData interpret( String regex ) {
		
		List<RegexToken> tokens = new ArrayList<RegexToken>();

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

		String subRegex = regex.substring( 1, regex.indexOf( ']' ) );
		CharGroupToken charGroupToken = new CharGroupToken( tokenizer.tokenize( subRegex ) );

		for ( ; min < max; min++ ) {
			// add the charGroupToken the number of times it was stated by the group quantifier
			tokens.add( charGroupToken );
		}

		// the resulting quantifierToken
		CharGroupQuantifierToken token = new CharGroupQuantifierToken( tokens );

		// new length is: 2 + 2 for both braces and the length of the quantifierString itself
		return new RegexPartData( token, subRegex.length() + 2 + quantifierString.length() + 2 );
	}

}
