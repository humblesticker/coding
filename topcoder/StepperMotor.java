public class StepperMotor {
	long getmin(long c, long t, long n) {
		if(c == t) return 0;
		
		long pos = (t - c)%n, neg = pos - n; 
		if(c > t) { neg = (t - c)%n; pos = n + neg; }
	
		if(Math.abs(neg) < pos) return neg;
		return pos;
	}
	
	public int rotateToNearest(int n, int c, int[] target) {
		c %= n;
		int min = Integer.MAX_VALUE;
		for(int t : target) {
			t %= n;
			int local = (int)getmin(c, t, n), amin = Math.abs(min), alocal = Math.abs(local);
			if(alocal < amin || (alocal == amin && local > 0)) min = local;
		}
		return min; 
	}
}