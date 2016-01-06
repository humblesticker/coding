import java.util.*;

public class SkipRope {
	class C implements Comparable<C> {
		public int h;
		public int d;
		public C(int h, int d) { this.h = h; this.d = d; }
		public int compareTo(C c) {
			if(d == c.d) return Integer.compare(c.h, h);
			return Integer.compare(d, c.d);
		}
	}
	
	public int[] partners(int[] candidates, int h) {
		C[] cs = new C[candidates.length];
		for(int i=0; i<candidates.length; i++) cs[i] = new C(candidates[i], Math.abs(h - candidates[i]));
		Arrays.sort(cs);
		
		int[] result = new int[] { cs[0].h, cs[1].h };
		Arrays.sort(result);
		return result;
	}
}
		