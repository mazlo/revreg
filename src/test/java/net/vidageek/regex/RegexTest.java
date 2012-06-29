package net.vidageek.regex;

import org.junit.Assert;
import org.junit.Test;

final public class RegexTest {

    @Test(expected = IllegalArgumentException.class)
    public void testThatThrowsExceptionIfStringIsNull() {
        new Regex(null);
    }

    @Test
    public void testThatAsStringReturnsTheSameStringPassed() {
        String regex = "abc";
        Assert.assertEquals(regex, new Regex(regex).asString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatThrowsExceptionIfRegexDoesNotCompile() {
        new Regex("ab(");
    }

	@Test
	public void test() {
		System.out.println( new Regex( "[0-3]{2}[A-C]{3,4}" ).generateMatchingWord() );
	}
}
