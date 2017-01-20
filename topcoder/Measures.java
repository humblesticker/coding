public class Measures {
	boolean good(int[] loudness, int start, int k) {
		int count = 0, total = 0;
		for(int i=start; i+k-1<loudness.length; i+=k) {
			boolean valid = true;
			for(int j=i+1; j<i+k; j++) 
				if(loudness[i] < loudness[j]) { valid = false; break; }
			total++; if(valid) count++;
		}
		return total > 0 ? count*5 >= total*4 : false;
	}
	
	public int beatsPerM(int[] loudness) {
		for(int k=2; k<=10; k++) 
			for(int i=0; i<k; i++) if(good(loudness, i, k)) return k;
		return -1;
	}
}