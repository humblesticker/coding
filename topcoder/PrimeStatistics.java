public class PrimeStatistics {
	boolean[] find(int bound) {
		boolean[] flags = new boolean[bound+1];
		flags[0] = true; flags[1] = true;
		for(int n=2; n<flags.length; n++) {
			if(flags[n]) continue;
			for(int i=2; i*n<flags.length; i++) flags[i*n] = true;
		}
		return flags;
	}
	
	public int mostCommonRemainder(int l, int u, int mod) {
		boolean[] removed = find(u);
		int[] counts = new int[mod];
		for(int i=l; i<=u; i++) if(!removed[i]) counts[i%mod]++;
		
		int max = -1, index = 0;
		for(int i=0; i<counts.length; i++)
			if(counts[i] > max) { max = counts[i]; index = i; }
		return index;
	}
}