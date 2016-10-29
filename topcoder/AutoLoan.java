public class AutoLoan {
	double check(double p, double m, int t, double a) {
		for(int i=0; i<t; i++) p += (p*a/1200 - m);
		return p;
	}
	
	public double interestRate(double p, double m, int t) {
		double start = 0.0, end = 100.0, e = 1E-12, mid = 0.0;
		while((end - start)/start > e) {
			mid = (end+start)/2;
			double diff = check(p, m, t, mid);
			//System.out.println(mid + "," + diff);
			if(Math.abs(diff) < e) return mid;
			if(diff < 0) start = mid; else end = mid;
		}
		return mid;
	}
}