public class FindTriangle {
	long area(int x1, int y1, int z1, int x2, int y2, int z2) {
		long d1 = x1*y2 - y1*x2, d2 = x1*z2 - z1*x2, d3 = y1*z2 - z1*y2;
		return d1*d1 + d2*d2 + d3*d3;
	}
	
	public double largestArea(String[] points) {
		int n = points.length; char[] C = new char[n]; 
		int[] X = new int[n], Y = new int[n], Z = new int[n];
		for(int i=0; i<n; i++) {
			String[] ts = points[i].split(" ");
			C[i] = ts[0].charAt(0);
			X[i] = Integer.parseInt(ts[1]);
			Y[i] = Integer.parseInt(ts[2]);
			Z[i] = Integer.parseInt(ts[3]);
		}

		long max = 0;
		for(int i=0; i<n; i++) for(int j=i+1; j<n; j++) for(int k=j+1; k<n; k++) {
			if((C[i] == C[j] && C[i] == C[k]) || (C[i] != C[j] && C[i] != C[k] && C[j] != C[k])) 
				max = Math.max(max, area(X[j]-X[i], Y[j]-Y[i], Z[j]-Z[i], X[k]-X[i], Y[k]-Y[i], Z[k]-Z[i]));
		}
		return Math.sqrt(max)/2; 
	}
}