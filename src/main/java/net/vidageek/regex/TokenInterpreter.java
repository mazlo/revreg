package net.vidageek.regex;

import net.vidageek.regex.reader.RegexPartData;

/**
 * Provides methods to interpret parts of a regular expression.
 * 
 * @author matthaeus
 * 
 */
public interface TokenInterpreter {

	/**
	 * Decides whether this interpreter should interpret the regex passed
	 * 
	 * @param regex
	 * @return
	 */
    boolean accept(String regex);

	/**
	 * Interprets the passed regex and creates the RegexPartData, 
	 * which itself consists of a list of tokens.
	 * 
	 * @param regex
	 * @return
	 */
    RegexPartData interpret(String regex);

}
