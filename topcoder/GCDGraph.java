import java.util.*;

public class GCDGraph {
	private int gcd(int s, int l) {
		while(l%s > 0) { int r = l%s; l = s; s = r; }
		return s;
	}

	private List<Integer> factors(int n, int x, int k) {
		List<Integer> list = new LinkedList<Integer>();
		for(int i=k+1; i<=n; i++) if(gcd(i, x) > k)  list.add(i);
		return list;
	}
	
	public String possible(int n, int k, int x, int y) {
		if(x == y) return "Possible";
		List<Integer> list = factors(n, x, k);

		for(int i=k+1; i<=n; i++) {
			if(gcd(i, x) <= k) continue;
			for(int j : list) if(gcd(i, j) > k) return "Possible";
		}

		return "Impossible";
	}
}	