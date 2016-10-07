public class AutoLoan {
	public double interestRate(double p, double m, int t) {
		double start = 0.0, end = 100.0, e = 10E-9;
		while(end - start > e) {
			double a = (start + end)/2, r = 1 + a/1200,
				temp = t*Math.log(r) + Math.log(p*(1-r)/m + 1);
			//System.out.println(a + "," + temp);
			if(Math.abs(temp) < e) return a;
			if(temp > 0) start = a; else end = a;
		}
		return -1.0; // NA;
	}

	public static void main(String[] args) {
		System.out.println(0.1 + 0.2);
		System.out.println((new AutoLoan()).interestRate(6800.0, 680.0, 10));
	}
}