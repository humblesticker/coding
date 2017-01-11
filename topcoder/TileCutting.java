import java.util.*;

// https://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm282
public class TileCutting {
	int cut = 0;
	
	private int[] count(String[] layout) {
		int[] decors = new int[3];
		for(int i=0; i<layout.length; i+=2)
			for(int j=0; j<layout[i].length(); j+=2) {
				int count = 0;
				if(layout[i].charAt(j) == '.') count++;
				if(layout[i].charAt(j+1) == '.') count++;
				if(layout[i+1].charAt(j) == '.') count++;
				if(layout[i+1].charAt(j+1) == '.') count++;
				if(count < 1 || count > 3) continue;
				
				if(count == 2 && layout[i].charAt(j) == layout[i+1].charAt(j+1)) decors[0] += 2;
				else decors[count-1]++;
			}
		
		return decors;
	}

	int combine(int[] ds) {
		int min = Math.min(ds[0], ds[2]), even = ds[1]/2;
		cut += 2 * min; ds[0] -= min; ds[2] -= min; 
		cut += 2 * even; ds[1] -= 2 * even;

		int sum = 0;
		for(int i=0; i<ds.length; i++) 
			while(ds[i] > 0) { cut++; ds[i]--; sum += (i+1); if(sum >= 4) return sum; }
		return sum;
	}
	
	public int cuts(String[] layout) {
		int[] ds = count(layout); int sum = combine(ds);
		while (sum >= 4) {
			int r = sum%4; if(r > 0) ds[r-1]++;
			sum = combine(ds);
		} 

		if(sum > 0) cut++;
		return cut;
	}
}