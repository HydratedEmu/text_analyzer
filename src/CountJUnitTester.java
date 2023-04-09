import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Sammy Garcia
 * @version 1.0
 * @since 04/09/2023
 * 
 */
class CountJUnitTester {

	@Test
	void test() throws Exception {
		Main1 m1 = new Main1();
		String s = m1.wordMain("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
		char number = s.charAt(4);
		char number2 = s.charAt(5);
		int theNumber = Integer.parseInt("" + number + number2);
		System.out.println(theNumber);
		assertEquals(theNumber, 56);

	}

}
