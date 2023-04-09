import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MapSorter {

	/**
	 * Constructor for the MapSorter class.
	 * 
	 * @author Sammy Garcia
	 * @version 1.0
	 * @since 04/09/2023
	 * 
	 * @param m  the map to be sorted
	 * @param al the ArrayList where the sorted key-value pairs will be stored
	 */

	public MapSorter(Map m, ArrayList<Item> al) {
		// System.out.println("In the Class");
		// System.out.println(m);

		// put Key,Value into List and sort list by value
		Set<Map.Entry<String, Integer>> x = m.entrySet();
		for (Map.Entry e : x) {
			al.add(new Item((String) e.getKey(), (Integer) e.getValue()));
		}

	}
}

class Item {
	String word;
	Integer count;

	public Item(String word, Integer count) {
		super();
		this.word = word;
		this.count = count;
	}

}