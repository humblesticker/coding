public class PseudoPrimeTest {
	private int fast(int b, int q) {
		if(factor == 0) return 1;
		
		int n = fast(b, factor/2, q), r = (n*n)%q;
		return factor%2 == 0 ? r : (b*r)%q;
	}
	
	public int firstFail(int q) {
		for(int i=2; i<q; i++) if(fast(i, q) != 1) return i;
		return q;
	}
}