public class RockStar {
	/*
		1, 1, 1, 1 - 4 ff - fs - ss - sf
		1, 1, 2, 1 - 5 ss - sf - fs - sf - ff, 4 ff - fs - ss - sf 
		1, 1, 3, 1 - 

		ff, A, B, ss - ff + ss 
		if A == B 2*A
		if A < B 2*A+1, 2*A (for fast first)
		if B < A 2*B+1
	*/
	private int getNumSongs(int ff, int fs, int sf, int ss, boolean fastFirst) {
		if(fs < sf) {
			if(fastFirst) return ff + ss + 2*fs;
			return ff + ss + 2*fs + 1;
		} else if(fs > sf) {
			return ff + ss + 2*sf + 1;
		} else {
			return ff + ss + 2*fs;
		}
	}

	/*
		special handle 0 
		1, 1, 0, 1 - 3 ff + 1 + ss
		1, 0, 1, 1 - 3 ss + 1 + ff, ff (for fast first)
		A, 0, 0, B - max(A, B), A (for fast first)
	*/
	public int getNumSongs(int ff, int fs, int sf, int ss) {
		boolean fastFirst = ff > 0 || fs > 0;
		if(fs == 0 && sf == 0) {
			if(fastFirst) return ff; 
			return Math.max(ff, ss);
		} else if(fs == 0) {
			if(fastFirst) return ff;
			return ss + 1 + ff; 
		} else if(sf == 0) { 
			return ff + 1 + ss;
		} else {
			return getNumSongs(ff, fs, sf, ss, fastFirst);
		}
 	}
}