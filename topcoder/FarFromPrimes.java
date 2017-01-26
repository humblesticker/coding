/*
far(i)
	j from i-10 to i+10
		if no prime 

n from A to B
	if far(n) far++
	
~ 2x10^6

get all primes till 10^5
*/
public class FarFromPrimes {
	// false means primes
	boolean[] find(int bound) {
		boolean[] flags = new boolean[bound+1];
		flags[0] = true; flags[1] = true;
		for(int n=2; n<flags.length; n++) {
			if(flags[n]) continue;
			for(int i=2; i*n<flags.length; i++) flags[i*n] = true;
		}
		return flags;
	}
	
	boolean far(int n, boolean[] primes) {
		for(int i=n-10; i<=n+10; i++) {
			if(i<0 || i>=primes.length) continue;
			if(!primes[i]) return false;
		}
		return true;
	}
	
	public int count(int A, int B) {
		boolean[] primes = find(100000);
		
		int far = 0;
		for(int n=A; n<=B; n++) if(far(n, primes)) far++;
		return far;
	}
}
	