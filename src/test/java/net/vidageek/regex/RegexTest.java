package net.vidageek.regex;

import org.junit.Assert;
import org.junit.Test;

final public class RegexTest {

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
	public void test() {
		System.out.println( new RegexGenerator( "\\d{2}[a-zA-Z]{3,4}" ).generateMatchingWord() );
	}

	// TODO add tests
}
