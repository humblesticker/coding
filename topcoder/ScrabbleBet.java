/*
DP or Binomial distribution n choose k
*/
public class ScrabbleBet {
	int w; double p; double op;

	private double walk(double d, int g, int ow) {
		if(g < 0) return 0.0;
		if(ow < 0) return d;
		return walk(d*p, g-1, ow) + walk(d*op, g-1, ow-1);
	}
	
	public double estimate(int t, int g, int w, int p) {
		this.w = w; this.p = p/100.0; this.op = (100-p)/100.0;
		return 1.0 - Math.pow(walk(1.0, g, g-w), t);
	}
}