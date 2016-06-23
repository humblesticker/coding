public class ShoelaceLength {
	public double calculate(int startWidth, int endWidth, int spread, int numPairs) {
		int step = numPairs - 1;
		double d = (double)(startWidth - endWidth)/step,  
			start = (double)startWidth,
			length = start;
		while(step > 0) {
			double base = start - d/2;
			length += 2 * Math.sqrt(base*base + spread*spread);
			start -= d; step--;
		}
		return length;
	}
}