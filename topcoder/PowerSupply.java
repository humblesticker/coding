public class PowerSupply {
	int count(int a, int[] y, int D) {
		int count = 0; 
		for(int n : y) if(Math.abs(a-n) <= D) count++;
		return count;
	}
	
	int count(int s, int a, int[] x, int[] y, long D) {
		int count = 0; long D2 = 2*D*D;
		for(int i=0; i<x.length; i++) {
			long d = s*x[i] + y[i] + a; if(d*d <= D2) count++;
		}
		return count; 
	}

	public int maxProfit(int[] x, int[] y, int D) {
		int max = 0;
		for(int i=-1000000; i<=1000000; i++) {
			max = Math.max(max, count(i, y, D));
			max = Math.max(max, count(i, x, D));
			max = Math.max(max, count(1, i, x, y, D));
			max = Math.max(max, count(-1, i, x, y, D));
		}
		return max;
	}
}
/*
distance: from point to a line
	diagonal: intersection with y = -x + a, y = x + a
		2*b^2 = a^2
		a^2/2 <= D
		
		intersection 
*/