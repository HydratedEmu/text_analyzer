import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WordJUnitTester {

	@Test
	void test() throws Exception {
		Main1 m1 = new Main1();
		//System.out.println(m1.wordMain("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm"));
		String s = m1.wordMain("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
		String firstWord = s.substring(0 , 3);
		//System.out.println(firstWord);
		assertEquals(firstWord, "the");
		
		}
		

}
