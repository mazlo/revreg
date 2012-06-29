package net.vidageek.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {

	public static final List<Character> letters = new ArrayList<Character>();
	public static final List<Character> digits = new ArrayList<Character>();
	public static final List<Character> spaces = new ArrayList<Character>();
	public static final List<String> shortCharset = new ArrayList<String>();

	public static final Map<String, List<Character>> map = new HashMap<String, List<Character>>();

	static {
		letters.add( 'A' );
		letters.add( 'B' );
		letters.add( 'C' );
		letters.add( 'D' );
		letters.add( 'E' );
		letters.add( 'F' );
		letters.add( 'G' );
		letters.add( 'H' );
		letters.add( 'I' );
		letters.add( 'J' );
		letters.add( 'K' );
		letters.add( 'L' );
		letters.add( 'M' );
		letters.add( 'N' );
		letters.add( 'O' );
		letters.add( 'P' );
		letters.add( 'Q' );
		letters.add( 'R' );
		letters.add( 'S' );
		letters.add( 'T' );
		letters.add( 'U' );
		letters.add( 'V' );
		letters.add( 'W' );
		letters.add( 'X' );
		letters.add( 'Y' );
		letters.add( 'Z' );

		letters.add( 'a' );
		letters.add( 'b' );
		letters.add( 'c' );
		letters.add( 'd' );
		letters.add( 'e' );
		letters.add( 'f' );
		letters.add( 'g' );
		letters.add( 'h' );
		letters.add( 'i' );
		letters.add( 'j' );
		letters.add( 'k' );
		letters.add( 'l' );
		letters.add( 'm' );
		letters.add( 'n' );
		letters.add( 'o' );
		letters.add( 'p' );
		letters.add( 'q' );
		letters.add( 'r' );
		letters.add( 's' );
		letters.add( 't' );
		letters.add( 'u' );
		letters.add( 'v' );
		letters.add( 'w' );
		letters.add( 'x' );
		letters.add( 'y' );
		letters.add( 'z' );

		digits.add( '0' );
		digits.add( '1' );
		digits.add( '2' );
		digits.add( '3' );
		digits.add( '4' );
		digits.add( '5' );
		digits.add( '6' );
		digits.add( '7' );
		digits.add( '8' );
		digits.add( '9' );

		spaces.add( ' ' );

		map.put( "\\d", digits );
		map.put( "\\s", spaces );
	}
}
