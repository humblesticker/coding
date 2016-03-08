public class TandemRepeats {
	private boolean matched(String dna, String sub, int start, int k) {
		int len = dna.length();
		for(int i=0; i<sub.length(); i++, start++) {
			if(start >= len) return false;
			if(sub.charAt(i) != dna.charAt(start)) { 
				if(k > 0) k--; else return false;
			}
		}
		return true;
	}
	
	public int maxLength(String dna, int k) {
		int max = 0;
		for(int i=0; i<dna.length(); i++) {
			for(int j=i+1; j<dna.length(); j++) {
				String sub = dna.substring(i, j);
				if(matched(dna, sub, j, k)) max = Math.max(max, sub.length());
			}
		}
		return max;
	}
}