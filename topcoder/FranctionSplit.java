/*
1. luf 
	from i=2 to forever 
		if 1/i < n/d return i

2. update n/d
	gcd = gcd(i, d)
	d: i * d / gcd
	n: (n * i - d) / gcd
	
List<String> out
while n > 0
	i = luf(n, d) 
	add 1/i to out
	update n, d 
	
Analysis ?
*/
import java.util.*;

public class FractionSplit {
	int getLuf(int n, int d) {
		double f = (double)n/d;
		int i=2; 
		while(true) {
			if(1.0/i <= f) return i;
			i++;
		}
	}
	
	int getGcd(int s, int l) {
		while(s != 0) {
			int r = l%s;
			l = s; s = r;
		}
		return l;
	}
	
	public String[] getSum(int n, int d) {
		List<String> out = new ArrayList<String>();
		while(n > 0) {
			int luf = getLuf(n, d);
			out.add("1/" + luf);
			
			int gcd = getGcd(luf, d);
			n = (n * luf - d) / gcd; d = luf * d / gcd;
		}
		return out.toArray(new String[0]);
	}
}
		
		
	
	
	
	
	 
