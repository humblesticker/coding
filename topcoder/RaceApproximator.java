public class RaceApproximator {
	private String format(int t) { return t > 9 ? "" + t : "0" + t; }

	public String timeToBeat(int d1, int t1, int d2, int t2, int d) {
		double a1 = Math.log((double)t2/t1), a2 = Math.log((double)d1/d), a3 = Math.log((double)d1/d2);
		int t = (int)(t1 * Math.exp(a1*a2/a3));

		int h = t/3600; t -= h*3600; 
		int m = t/60; t -= m*60;		
		return h + ":" + format(m) + ":" + format(t);
	}
}