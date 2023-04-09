
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * A class that extracts the most frequently used words from a webpage.
 * 
 * @author Sammy Garcia
 * @version 1.0
 * @since 04/09/2023
 */

public class Main1 {

	/**
	 * Extracts the most used words from the poem's webpage.
	 * 
	 * @param webAddress is the address of the poem to extract words from
	 * @return a string containing the top 20 most frequently used words and their
	 *         counts
	 * @throws Exception if an error occurs while connecting to the webpage
	 */
	public static String wordMain(String webAddress) throws Exception {

		int count = 0, maxCount = 0;

		String sentence, word = "";

		ArrayList<Item> items = new ArrayList<>();

		Document doc = Jsoup.connect(webAddress).get();

		// Extract all text within <p> tags from (poem's) webpage
		String total = "";
		Elements poem = doc.select("p");
		for (Element lines : poem) {
			total += lines.text();

		}

		// remove punctuation marks and convert all text to lowercase
		total = total.toLowerCase();
		total.replaceAll(";", "");
		total.replaceAll(",", "");
		total.replaceAll("!", "");

		// Split the text into an array of individual words
		// and count the frequency of each word
		String totalArray[] = total.split(" ");
		Map m = new HashMap<String, Integer>();
		for (int i = 0; i < totalArray.length; i++) {
			if (m.containsKey(totalArray[i])) {
				m.put(totalArray[i], (Integer) (m.get(totalArray[i])) + 1);
			} else {
				m.put(totalArray[i], 1);
			}
		}

		// Sort the words by their frequency count in descending order
		MapSorter ms = new MapSorter(m, items);

		Collections.sort(items, new Comparing());

		// Create a string with the top 20 most
		// frequently used words and their counts
		int i = 0;
		String output = "";

		for (Item item : items) {
			output += item.word + " " + item.count + "\n";
			i++;
			if (i > 20) {
				break;
			}
		}

		return output;

	}// end main
}// end class

/**
 * 
 * A class to compare the counts of two items.
 */
class Comparing implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		if (o1.count < o2.count) {
			return 1;
		}
		return -1;
	}

}