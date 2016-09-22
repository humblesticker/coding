public class TableSeating {
	double expect(int psize, int tcount, double[] expects, int[] probs) {
		int total = 0;
		for(int i=0; i<tcount-psize; i++) {
			total += psize;
			if(i>0) total += expects[i];
			if(i<tcount-psize) total += expects[tcount-psize-i];
		}
		return total * probs[psize-1] / (tcount-psize+1);
	}

	double expect(int tcount, double[] expects, int[] probs) {
		double total = 0.0;
		for(int i=0; i<tcount; i++) total += expect(i+1, tcount, expects, probs);
		return total;
	}
	
	public double getExpected(int tcount, int[] probs) {
		double[] expects = new double[tcount+1];
		expects[1] = probs[0];
		for(int i=2; i<=tcount; i++) expects[i] = expect(i, expects, probs);
		return expects[tcount];
	}
}