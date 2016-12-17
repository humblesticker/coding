/*
for n>k get smallest factor for x and y
return lx*ly/gcd(lx,ly) <= n
*/
public class GCDGraph {
	private int gcd(int s, int l) {
		while(l%s > 0) {
			int r = l%s;
			l = s; s = r;
		}
		return s;
	}
	
	private int least(int n, int x, int k) {
		for(int i=k+1; i<=n; i++) 
			if(x%i == 0) return i;
		return -1; //NA
	}
	
	public String possible(int n, int k, int x, int y) {
		int lx = least(n, x, k), ly = least(n, y, k), gcd = gcd(lx, ly);
		System.out.println(lx + "," + ly + "," + gcd);
		if(lx > k && ly > k && lx*ly/gcd(lx, ly) <= n) return "Possible";
		return "Impossible";
	}
}