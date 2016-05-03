public class RedSquare {	
	public int countTheEmptyReds(int mr, int mf, int[] r, int[] f) {
		int count = 0; boolean even = mf%2 == 0;
		for(int i=0; i<r.length; i++) {
			boolean pos = (r[i] + f[i])%2 == 0; 
			if(pos == even) count++;
		}
		return mr*mf/2 - count;
	}
}