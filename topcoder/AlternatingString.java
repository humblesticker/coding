/*
look ahead 
*/
public class AlternatingString {
	public int maxLength(String s) {
		int max = 1, count = 1, len = s.length();
		for(int i=0; i<len; i++) {
			if(i == len-1 || s.charAt(i) == s.charAt(i+1)) {
				max = Math.max(max, count); count = 1; 
			} else count++;
		}
		return max;
	}
}