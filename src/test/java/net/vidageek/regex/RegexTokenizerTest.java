package net.vidageek.regex;

import java.util.List;

import junit.framework.Assert;
import net.vidageek.regex.token.CharGroupToken;
import net.vidageek.regex.token.SimpleCharQuantifierToken;
import net.vidageek.regex.token.SimpleCharToken;

import org.junit.Before;
import org.junit.Test;

final public class RegexTokenizerTest {

    private RegexTokenizer tokenizer;

    @Before
    public void setup() {
        tokenizer = new RegexTokenizer();
    }

    @Test
    public void testThatTokenizesSimpleChar() {
        List<RegexToken> list = tokenizer.tokenize("a");
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(SimpleCharToken.class, list.get(0).getClass());
    }

    @Test
    public void testThatTokenizesTwoChar() {
        List<RegexToken> list = tokenizer.tokenize("ab");
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(SimpleCharToken.class, list.get(0).getClass());
        Assert.assertEquals(SimpleCharToken.class, list.get(1).getClass());
    }

    @Test
    public void testThatTokenizesCharGroup() {
		List<RegexToken> list = tokenizer.tokenize( "[a-c]" );
        Assert.assertEquals(1, list.size());
        Assert.assertEquals(CharGroupToken.class, list.get(0).getClass());
    }

	@Test
	public void testSimpleCharQuantifier() {
		List<RegexToken> list = tokenizer.tokenize( "a{2}" );
		Assert.assertEquals( 1, list.size() );
		Assert.assertEquals( SimpleCharQuantifierToken.class, list.get( 0 ).getClass() );

		list = tokenizer.tokenize( "ab{2}" );
		Assert.assertEquals( 2, list.size() );
		Assert.assertEquals( SimpleCharToken.class, list.get( 0 ).getClass() );
		Assert.assertEquals( SimpleCharQuantifierToken.class, list.get( 1 ).getClass() );

		Assert.assertEquals( 2, list.get( 1 ).getTokens().size() );
	}

	@Test
	public void testLetterCharGroupTokens() {
		List<RegexToken> list;

		list = tokenizer.tokenize( "[ab]" );
		Assert.assertEquals( 2, list.get( 0 ).getTokens().size() );

		list = tokenizer.tokenize( "[a-d][e-h]" );
		Assert.assertEquals( 4, list.get( 0 ).getTokens().size() );

		list = tokenizer.tokenize( "[a-d,][e-h]" );
		Assert.assertEquals( 5, list.get( 0 ).getTokens().size() );
		Assert.assertEquals( 4, list.get( 1 ).getTokens().size() );
	}

	@Test
	public void testLetterCharGroupQuantifierTokens() {
		List<RegexToken> list;

		list = tokenizer.tokenize( "[a]{3}" );
		Assert.assertEquals( 3, list.get( 0 ).getTokens().size() );

		list = tokenizer.tokenize( "[a-z]{3}" );
		Assert.assertEquals( 3, list.get( 0 ).getTokens().size() );

		list = tokenizer.tokenize( "[a-zA-z]{2}" );
		Assert.assertEquals( 2, list.get( 0 ).getTokens().size() );
	}

	@Test
	public void testDigitCharGroupTokens() {
		List<RegexToken> list;

		list = tokenizer.tokenize( "[39]" );
		Assert.assertEquals( 2, list.get( 0 ).getTokens().size() );

		list = tokenizer.tokenize( "[0-3]" );
		Assert.assertEquals( 4, list.get( 0 ).getTokens().size() );

		list = tokenizer.tokenize( "[0-3,]" );
		Assert.assertEquals( 5, list.get( 0 ).getTokens().size() );
	}

	@Test
	public void testDigitCharGroupQuantifierTokens() {
		List<RegexToken> list;

		list = tokenizer.tokenize( "[3]{2}" );
		Assert.assertEquals( 2, list.get( 0 ).getTokens().size() );

		list = tokenizer.tokenize( "[0-9]{2}" );
		Assert.assertEquals( 2, list.get( 0 ).getTokens().size() );

	}

	@Test
	public void testShortChars() {
		List<RegexToken> list;

		list = tokenizer.tokenize( "\\d{3}" );
		Assert.assertEquals( 3, list.get( 0 ).getTokens().size() );

		list = tokenizer.tokenize( "\\s{3}" );
		Assert.assertEquals( 3, list.get( 0 ).getTokens().size() );

	}

}