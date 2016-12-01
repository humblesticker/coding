public class FallingCoconuts {
	String[] display(int[] counts, int start, int end, int h) {
		String[] config = new String[h];
		for(int i=0; i<config.length; i++) config[i] = "";
		
		for(int row=0; row<config.length; row++) 
			for(int col=start; col<=end; col++) 
				config[row] += (counts[col] > row ? 'O' : '-');
		return config;
	}
	
	// recursive
	void locate(int loc, int[] counts) {
		if(counts[loc] == 0 || counts[loc+1] == counts[loc-1]) { counts[loc]++; return; }
		if(counts[loc+1] < counts[loc]) locate(loc+1, counts);
		else locate(loc-1, counts);
	}
	
	// shift by 100 to avoid negative index
	public String[] harvest(int[] drops) {
		int[] counts = new int[1000];
		for(int drop : drops) locate(drop+100, counts);

		int start = 1000, end = -1, h = 0;
		for(int i=0; i<counts.length; i++) {
			if(counts[i] <= 0) continue;
			start = Math.min(start, i); end = Math.max(end, i); 
			h = Math.max(h, counts[i]);
		}
		return display(counts, start, end, h);
	}
}