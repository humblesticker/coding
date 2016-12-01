public class PalindromeMaker {	
	public String make(String base) {
		int[] count = new int[26];
		for(char c : base.toCharArray()) count[c-'A']++;
		
		int odd = 0; String s = "";
		for(int i=0; i<count.length; i++) 
			if(count[i]%2 == 1) { odd++; s += (char)('A'+i); count[i]--; } // handle AAA
		
		if(odd > 1) return "";
		for(int i=count.length-1; i>=0; i--) {
			int occur = count[i]/2; char c = (char)('A'+i);
			String w = ""; while(occur-- > 0) w += c;
			s = w + s + w;
		}
		return s;
	}
}