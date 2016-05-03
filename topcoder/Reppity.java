public class Reppity {
	public int longestRep(String input) {
		int max = 0;
		for(int i=0; i<input.length(); i++) 
			for(int j=i+1; j<input.length(); j++) 
				if(input.indexOf(input.substring(i, j), j) >= 0) max = Math.max(max, j-i);
		return max;
	}
}