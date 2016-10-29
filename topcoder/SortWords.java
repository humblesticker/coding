import java.util.*;

public class SortWords {
	boolean isTitle(String s) {
		String[] words = s.toLowerCase().split("\\s+");
		if(words.length > 3) return true;
		for(String w : words) 
			if("the".equals(w) || "and".equals(w) || "of".equals(w)) return true;
		return false;
	}

	public int[] checkManually(String[] f1, String[] f2) {
		List<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<f1.length; i++) 
			if(isTitle(f1[i]) == isTitle(f2[i])) list.add(i);

		Collections.sort(list);
		return list.stream().mapToInt(i->i).toArray();
	}
}
/*
req
	title
		words > 3
		one of words is the, and, of 

if both or neither title add
sort and return
*/
