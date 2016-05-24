public class GerrymanderEasy {
	private double getmaxForK(int[] A, int[] B, int K, int sumA, int sumB) {
		double max = (double)sumB/sumA;
		
		for(int i=1; i<=A.length-K; i++) {
			sumA = sumA - A[i-1] + A[i+K-1]; 
			sumB = sumB - B[i-1] + B[i+K-1];
			double local = (double)sumB/sumA; if(local > max) max = local;
		}
		return max;
	}
	
	public double getmax(int[] A, int[] B, int K) {
		int sumA = 0, sumB=0;
		for(int i=0; i<K; i++) { sumA += A[i]; sumB += B[i]; }

		double max = -1.0;
		while(K <= A.length) { 
			double local = getmaxForK(A, B, K, sumA, sumB); if(local > max) max = local;
			if(K < A.length) { sumA += A[K]; sumB += B[K]; }
			K++; 
		}
		return max;
	}
}