/*
dp ~ 500
	S(n) = min { S(n-1, q), S(n-1, q-Un) + Un, ... Un*f }

brute force ~ 10^8

*/
import java.util.*;

public class VolumeDiscount {
	class Volume {
		int unit; int cost; Volume(int u, int c) { unit = u; cost = c; }
	}

	int min = Integer.MAX_VALUE;

	void walk(Volume[] vs, int pos, int q, int cost) {
		if(q <= 0) { min = Math.min(min, cost); return; }
		if(pos < 0) return;
		
		while(q + vs[pos].unit > 0) {
			walk(vs, pos-1, q, cost);
			q -= vs[pos].unit; cost += vs[pos].cost;
		}
	}

	public int bestDeal(String[] list, int q) {
		Volume[] vs = new Volume[list.length];
		for(int i=0; i<vs.length; i++) {
			String[] ts = list[i].split(" ");
			vs[i] = new Volume(Integer.parseInt(ts[0]), Integer.parseInt(ts[1]));
		}

		walk(vs, vs.length-1, q, 0);
		return min;
	}
}