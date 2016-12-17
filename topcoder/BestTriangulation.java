public class BestTriangulation {
	int area(int i, int j, int k, int[] xs, int[] ys) {
		return Math.abs(
			xs[j]*ys[k] - xs[k]*ys[j] +
			xs[k]*ys[i] - xs[i]*ys[k] + 
			xs[i]*ys[j] - xs[j]*ys[i];
		);
	}

	public double maxArea(String[] vs) {
		int[] xs = new int[vs.length], ys = new int[vs.length];
		for(int i=0; i<vs.length; i++) { 
			String[] tokens = vs[i].split(" ");
			xs[i] = Integer.parseInt(tokens[0]);
			ys[i] = Integer.parseInt(tokens[1]);
		}
		
		int max = 0;
		for(int i=0; i<vs.length; i++)
			for(int j=i+1; j<vs.length; j++) 
				for(int k=j+1; k<vs.length; k++) 
					max = Math.max(max, area(i, j, k, xs, ys));
		return max/2.0;
	}
}