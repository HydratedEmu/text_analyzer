

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
/*
 * 
 * 
 * */

public class Main {

	public static void main(String[] args) throws Exception {

		int count = 0, maxCount = 0;

		String sentence, word = "";

		ArrayList<Item> items = new ArrayList<>();

		Document doc = Jsoup.connect("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm").get();
		// log(doc.title());
		String total = "";
		Elements poem = doc.select("p");
		for (Element lines : poem) {
			//System.out.println(lines.text());
			total += lines.text();
			
		}
		
		total = total.toLowerCase();
		total.replaceAll(";", "");
		total.replaceAll(",", "");
		total.replaceAll("!", "");
		//String totalArray[] = total.split("; .\"!-,\n");
		String totalArray[] = total.split(" ");
		
		Map m = new HashMap<String ,Integer>();
		for(int i = 0; i < totalArray.length; i++) {
			//System.out.println( totalArray[i] );
			//regex or OR inside split() above
	
			if(m.containsKey(totalArray[i])) {
				m.put(totalArray[i],(Integer) (m.get(totalArray[i])) +1 );
			}else {
				m.put(totalArray[i], 1);
			}
		}
		
		//System.out.println(m);
		
		MapSorter ms = new MapSorter(m, items);
		
		Collections.sort(items,new C2());
		
		//next step, create a class to put Key,Value into List and sort list by value

		int i = 0;
		for(Item item: items) {
			System.out.println(item.word +" "+ item.count);
			i++;
			if(i > 20) {
				break;
			}
		}
		
	}// end main
}// end class

class C2 implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		if(o1.count < o2.count) {
			return 1;
		}
		return -1;
	}
	
}