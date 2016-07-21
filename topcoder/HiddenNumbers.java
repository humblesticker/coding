import java.util.*;

public class HiddenNumbers {
	private class Number implements Comparable<Number> {
		long value; String str; 
		Number(long v, String s) { value = v; str = s; }
		public int compareTo(Number other) {
			if(value == other.value) return Integer.compare(str.length(), other.str.length());
			return Long.compare(value, other.value);
		}
	}
	
	private List<Number> extract(String[] text) {
		String cur = ""; List<Number> list = new ArrayList<Number>();
		for(String t : text) {
			for(char c : t.toCharArray()) {
				if(Character.isDigit(c)) cur += c;
				else { 
					if(cur.length() > 0) { 
						list.add(new Number(Long.parseLong(cur), cur)); 
						cur = ""; 
					}
				}
			}
		}
		// last one
		if(cur.length() > 0) list.add(new Number(Long.parseLong(cur), cur)); 
		return list;
	}
	
	public String[] findAll(String[] text) {
		List<Number> list = extract(text);
		Collections.sort(list);
		String[] out = new String[(list.size()+1)/2];
		int start = list.size()/2;
		for(int i=start; i<list.size(); i++) out[i-start] = list.get(i).str;
		return out;
	}
}