import java.util.*;

public class OmahaLow {
	private String under9 = "12345678";
	private String remove(String s) {
		StringBuilder b = new StringBuilder();
		for(char c : s.toCharArray()) if(under9.indexOf(c) >= 0) b.append(c);
		return b.toString();
	}
	
	private List<String> hands(String hand) {
		List<String> list = new ArrayList<String>();
		for(int i=0; i<hand.length(); i++) 
			for(int j=i+1; j<hand.length(); j++)
				list.add("" + hand.charAt(i) + hand.charAt(j));	
		return list;	
	}
	
	private List<String> shareds(String shared) {
		List<String> list = new ArrayList<String>();
		for(int i=0; i<shared.length(); i++) 
			for(int j=i+1; j<shared.length(); j++)
				for(int k=j+1; k<shared.length(); k++)
					list.add("" + shared.charAt(i) + shared.charAt(j) + shared.charAt(k));	
		return list;	
	}

	private int sum(String s) {
		int sum = 0;
		for(char c : s.toCharArray()) sum += Character.getNumericValue(c);
		return sum;
	}

	private boolean duplicate(String s) {
		Set<Character> set = new HashSet<Character>();
		for(char c : s.toCharArray()) {
			if(set.contains(c)) return true;
			set.add(c);
		}
		return false;
	}
	
	public String low(String shared, String hand) {
		int min = Integer.MAX_VALUE; String selected = "";
		List<String> hands = hands(remove(hand)), shareds = shareds(remove(shared));
		for(String h : hands) 
			for(String s : shareds) {
				String t = h + s;
				if(duplicate(t)) continue;
				int sum = sum(t); if(sum < min) { min = sum; selected = t; }
			}

		char[] array = selected.toCharArray();
		Arrays.sort(array);	

		StringBuilder b = new StringBuilder();
		for(int i=array.length-1; i>=0; i--) b.append(array[i]);
		return b.toString();
	}
}