public class RockStar {
	private int count(int a, int b, int c, int d) {
		if(b == 0) return a;
		if(b>c) return a + 2*c + 1 + d;
		return a + 2*b + d;
	}

	public int getNumSongs(int ff, int fs, int sf, int ss) {
		int fast = count(ff, fs, sf, ss), slow = count(ss, sf, fs, ff);
		if(ff > 0 || fs > 0) return fast;
		return Math.max(fast, slow);
 	}
}