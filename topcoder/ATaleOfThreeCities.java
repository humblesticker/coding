/*
get min from AB, AC, BC
get min 2 sum of above 
*/
public class ATaleOfThreeCities {
	private double min(int[] ax, int[] ay, int[] bx, int[] by) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<ax.length; i++) 
			for(int j=0; j<bx.length; j++) {
				int dx = ax[i]-bx[j], dy = ay[i]-by[j]; 
				min = Math.min(min, dx*dx + dy*dy);
			}
		return Math.sqrt(min);
	}
	
	public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy) {
		double d1 = min(ax, ay, bx, by), d2 = min(ax, ay, cx, cy), d3 = min(bx, by, cx, cy);
		double min = Math.min(d1+d2, d1+d3); 
		return Math.min(min, d2+d3);
	}
} 