package net.vidageek.regex.reader;

import net.vidageek.regex.TokenInterpreter;
import net.vidageek.regex.token.SimpleCharToken;

final public class SimpleCharTokenInterpreter implements TokenInterpreter {

    public boolean accept(final String regex) {
		// do not match set statements, e.g. 0-9
		if ( regex.contains( "-" ) )
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
