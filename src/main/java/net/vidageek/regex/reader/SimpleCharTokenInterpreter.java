package net.vidageek.regex.reader;

import net.vidageek.regex.TokenInterpreter;
import net.vidageek.regex.token.SimpleCharToken;

final public class SimpleCharTokenInterpreter implements TokenInterpreter {

    public boolean accept(final String regex) {
		// do not match char group tokens
		if ( regex.startsWith( "[" ) )
			return false;

		// do not match set statements, e.g. 0-9
		if ( regex.contains( "-" ) )
			return false;

		if ( regex.startsWith( "\\" ) )
			return false;

		if ( regex.length() > 1 && regex.charAt( 1 ) == '{' )
			return false;

		// but match any character
		if ( Character.isDefined( regex.charAt( 0 ) ) ) {
            return true;
        }

        return false;
    }

    public RegexPartData interpret(final String regex) {
        return new RegexPartData(new SimpleCharToken(regex.charAt(0)), 1);
    }

}
