/*
group anagrams 
Map of List<String> keyed by sorted ~ O(nmlogm)
only if there is a anagram for a word
 */
import java.util.*;

public class Anagram {
	public List<List<String>> find(List<String> dicts) {
		HashMap<String, List<String>> map = new HashMap<>();
		for(String d : dicts) {
			char[] cs = d.toCharArray(); Arrays.sort(cs);
			String key = new String(cs);
			if(!map.containsKey(key)) map.put(key, new LinkedList<String>());
			map.get(key).add(d);
		}

		List<List<String>> group = new LinkedList<>();
		for(Map.Entry<String, List<String>> e : map.entrySet()) group.add(e.getValue());
		return group;
}
}