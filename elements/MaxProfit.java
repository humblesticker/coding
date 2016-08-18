/*
how to divide and conquer?
*/ 
public class MaxProfit {
	public double calculate(double[] starts) {
		double min = Double.MAX_VALUE, maxProfit = 0.0; 
		for(int i=0; i<starts.length; i++) {
			if(starts[i] < min) min = starts[i];
			double local = starts[i] - min; if(local > maxProfit) maxProfit = local;
		}
		return maxProfit;
	}
}