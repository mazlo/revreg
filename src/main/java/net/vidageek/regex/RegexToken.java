package net.vidageek.regex;

import java.util.List;

/**
 * Represents a token in the regular expression. A token can be seen as a part
 * of the regular expression. For example, the regular expression
 * <i>'[0-9]{3}[a-z]'</i> consists of 2 RegexToken, namely <i>[0-9]{3}</i> and
 * <i>[a-z]</i>.
 * 
 * @author matthaeus
 * 
 */
public interface RegexToken extends Comparable<RegexToken> {

    String getWord();

	List<RegexToken> getTokens();

}
