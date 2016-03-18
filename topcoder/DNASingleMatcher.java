import java.util.*;

public class DNASingleMatcher {
	private boolean match(String s1, String s2, int size) {
		Set<String> set = new HashSet<String>();
		for(int i=0; i<=s1.length()-size; i++) set.add(s1.substring(i, i+size));
		
		for(int i=0; i<=s2.length()-size; i++) 
			if(set.contains(s2.substring(i, i+size))) return true;
		return false;	
	}
	
	public int longestMatch(String s1, String s2) {
		int n1 = s1.length(), n2 = s2.length();
		n1 = Math.min(n1, n2); n2 = Math.max(n1, n2);
		
		for(int i=n1; i>0; i--)
			if(match(s1, s2, i)) return i;
		return 0;
	}
}

public class DNASingleMatcher {
	public int longestMatch(String s1, String s2) {
		for(int size=s1.length(); size>0; size--) 
			for(int start=0; start<=s1.length()-size; start++) 
				if(s2.indexOf(s1.substring(start, start+size)) >= 0) return size;
		return 0;			
	}
}