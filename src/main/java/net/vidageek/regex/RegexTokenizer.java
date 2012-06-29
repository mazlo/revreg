package net.vidageek.regex;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.regex.reader.CharGroupQuantifierTokenInterpreter;
import net.vidageek.regex.reader.CharGroupTokenInterpreter;
import net.vidageek.regex.reader.RegexPartData;
import net.vidageek.regex.reader.ShortSimpleCharTokenInterpreter;
import net.vidageek.regex.reader.SimpleCharSetTokenInterpreter;
import net.vidageek.regex.reader.SimpleCharTokenInterpreter;

final public class RegexTokenizer {

    private final List<TokenInterpreter> readers;

    public RegexTokenizer() {
        readers = new ArrayList<TokenInterpreter>();
		readers.add( new SimpleCharTokenInterpreter() ); // e.g. a
		readers.add( new CharGroupTokenInterpreter( readers ) ); // e.g. [abc]
		readers.add( new SimpleCharSetTokenInterpreter( this ) ); // e.g. [a-z]
		readers.add( new ShortSimpleCharTokenInterpreter( readers ) ); // e.g. \\d
		readers.add( new CharGroupQuantifierTokenInterpreter( this ) ); // e.g. [a-c]{3}
    }

    public RegexTokenizer(final List<TokenInterpreter> readers) {
        this.readers = readers;
    }

    public List<RegexToken> tokenize(String regex) {
        List<RegexToken> list = new ArrayList<RegexToken>();
        while (regex.length() != 0) {
            for (TokenInterpreter reader : readers) {
                if (reader.accept(regex)) {
					RegexPartData data = reader.interpret( regex );
                    list.addAll(data.tokens());
                    regex = regex.substring(data.offset());
                    break;
                }
            }
        }
        return list;
    }
}
