package net.vidageek.regex.datapoints;

import net.vidageek.regex.RegexGenerator;

import org.junit.experimental.theories.DataPoint;

public interface CharacterDatapoints {

    @DataPoint
    RegexGenerator a = new RegexGenerator("a");

    @DataPoint
    RegexGenerator b = new RegexGenerator("b");

    @DataPoint
    RegexGenerator ab = new RegexGenerator("[ab]");

}
