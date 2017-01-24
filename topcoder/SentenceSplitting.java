/*
simple
	cache

*/
public class SentenceSplitting {
	int[] spaces;
	String sentence;
	int min;
	
	//
	int navigate(int i, int k, String cur, int max) {
		if(i < 0 || k == 0) { 
			int local = Math.max(max, cur.length()); 
			min = Math.min(min, local); return local;
		}
		
		int start = i > 0 ? i-1 : 0;
		cur = sentence.substring(start, spaces[i]) + cur; 
		int max1 = navigate(i-1, k-1, "", Math.max(max, cur.length()-1)), // remove 1st space 
			max2 = navigate(i-1, k, cur, max); 
		return Math.max(max1, max2);
	}
	
	public int split(String sentence, int K) {
		// build spaces array, initialize properties
		navigate(spaces.length-1, K, "", 0);
	}
}
	