public class BadClock {
	private int getSec(String t) {
		String[] splits = t.split(":");
		return Integer.parseInt(splits[0]) * 3600 + Integer.parseInt(splits[1]) * 60 + Integer.parseInt(splits[2]);
	}

	private int getDiff(String c, String s) {
		return getSec(c) - getSec(s);
	}

	public double nextAgreement(String c, String s, int g) {
		int diff = getDiff(c, s); 
		if(diff * g < 0) diff = 12 * 3600 - Math.abs(diff);

		double next = (double)diff/g;
		if(next < 0) next *= -1;
		return next;
	}
}