public class FracCount {
	int gcd(int l, int s) {
		while(true) {
			int r = l%s; if(r == 0) return s;
			l = s; s = r;
		}
	}
	
	public int position(int num, int den) {
		int count = 0;
		for(int d=2; d<=den; d++)
			for(int n=1; n<d; n++) {
				if(gcd(d, n) == 1) count++;
				if(d == den && n == num) return count;			
			}
		return -1; // N/A
	}
}	
