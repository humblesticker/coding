public class StepperMotor {
	// tricky
	int less(int a, int b) {
		int aa = Math.abs(a), ab = Math.abs(b);
		if(aa == ab) return Math.max(a, b);
		return aa < ab ? a : b;
	}
	
	// loop
	public int rotateToNearest(int n, int c, int[] target) {
		c %= n; if(c < 0) c += n;
		int min = Integer.MAX_VALUE;

		for(int t : target) {
			t %= n; if(t < 0) t += n; 
			if(c == t) return 0;

			int d = t - c; if(d < 0) d += n;
			min = less(min, less(d, d-n));
		}

		return min; 
	}
}