package net.vidageek.regex.reader;

import java.util.List;

import net.vidageek.regex.Constants;
import net.vidageek.regex.RegexTokenizer;
import net.vidageek.regex.TokenInterpreter;
import net.vidageek.regex.token.CharGroupQuantifierToken;

public class ShortSimpleCharTokenInterpreter implements TokenInterpreter {

	private RegexTokenizer tokenizer;

	public ShortSimpleCharTokenInterpreter(List<TokenInterpreter> readers) {
		this.tokenizer = new RegexTokenizer( readers );
	}

	public boolean accept( String regex ) {
		if ( regex.startsWith( "\\" ) )
			// match \ in the beginning of the regex
			return true;

		return false;
	}

	public RegexPartData interpret( String shortRegex ) {

		String shortReg = shortRegex.substring( 0, 2 );
		String regex = Constants.map.get( shortReg );

		if ( regex == null ) {
			throw new IllegalArgumentException( "No such character defined" );
		}

		String postfixRegex = shortRegex.substring( 2 );
		CharGroupQuantifierToken token = new CharGroupQuantifierToken( tokenizer.tokenize( regex + postfixRegex ) );

		return new RegexPartData( token, shortRegex.length() );
	}

}
