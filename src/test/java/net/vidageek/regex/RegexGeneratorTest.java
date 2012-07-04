package net.vidageek.regex;

import org.junit.Assert;
import org.junit.Test;

final public class RegexGeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testThatThrowsExceptionIfStringIsNull() {
        new RegexGenerator(null);
    }

    @Test
    public void testThatAsStringReturnsTheSameStringPassed() {
        String regex = "abc";
        Assert.assertEquals(regex, new RegexGenerator(regex).getOriginalRegex());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatThrowsExceptionIfRegexDoesNotCompile() {
        new RegexGenerator("ab(");
    }

	@Test
	public void testDigitMatchingGenerator() {
		String generatedWord;

		generatedWord = RegexGenerator.generateMatchingWord( "[1]" );
		Assert.assertEquals( "1", generatedWord );

		generatedWord = RegexGenerator.generateMatchingWord( "[0-9]" );
		Assert.assertEquals( "0", generatedWord );

		generatedWord = RegexGenerator.generateMatchingWord( "[0-9]{4}" );
		Assert.assertEquals( "0000", generatedWord );

		generatedWord = RegexGenerator.generateMatchingWord( "\\d" );
		Assert.assertEquals( "0", generatedWord );

		generatedWord = RegexGenerator.generateMatchingWord( "\\d{4}" );
		Assert.assertEquals( "0000", generatedWord );
	}

	@Test
	public void testStringMatchingGenerator() {
		String generatedWord;

		generatedWord = RegexGenerator.generateMatchingWord( "[b]" );
		Assert.assertEquals( "b", generatedWord );

		generatedWord = RegexGenerator.generateMatchingWord( "[a-z]" );
		Assert.assertEquals( "a", generatedWord );

		generatedWord = RegexGenerator.generateMatchingWord( "[a-z]{4}" );
		Assert.assertEquals( "aaaa", generatedWord );
	}

	@Test
	public void testMixedMatchingGenerator() {
		String generatedWord;

		generatedWord = RegexGenerator.generateMatchingWord( "[0-9][a-zA-Z]" );
		Assert.assertEquals( "0a", generatedWord );

		generatedWord = RegexGenerator.generateMatchingWord( "\\d[a-zA-Z]" );
		Assert.assertEquals( "0a", generatedWord );

		generatedWord = RegexGenerator.generateMatchingWord( "\\d{2}[a-zA-Z]{3,4}" );
		Assert.assertEquals( "00aaa", generatedWord );

	}

}
