package net.vidageek.regex.reader;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.regex.RegexToken;

/**
 * Represents a special part of the regular expression statement, 
 * which might consist of a list of tokens.
 * 
 * @author matthaeus
 * 
 */
final public class RegexPartData {

    private final ArrayList<RegexToken> tokens;
    private final int offset;

    public RegexPartData(final RegexToken token, final int offset) {
        this.offset = offset;
        tokens = new ArrayList<RegexToken>();
        tokens.add(token);

    }

    public List<RegexToken> tokens() {
        return tokens;
    }

    public int offset() {
        return offset;
    }

	@Override
	public String toString() {
		return "" + tokens + "";
	}

}
