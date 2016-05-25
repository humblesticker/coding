public class GerrymanderEasy {	
	public double getmax(int[] A, int[] B, int K) {
		double max = -0.1;
		for(int i=0; i<A.length; i++) {
			int sumA = 0, sumB = 0;
			for(int j=i; j<A.length; j++) {
				sumA += A[j]; sumB += B[j];
				if(j-i+1 >= K) { 
					double local = (double)sumB/sumA;
					if(local > max) max = local;
				}
			}
		}
		return max;
	}
}