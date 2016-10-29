/*
array of boolean bound+1
n from 2 to bound
	if(flag[n] is true) continue
	i from n to bound 
		flag[i] = true
		i*=n
 */
import java.util.*;

public class SoE {
	static boolean[] find(int bound) {
		boolean[] flags = new boolean[bound+1];
		for(int n=2; n<flags.length; n++) {
			if(flags[n]) continue;
			for(int i=2; i*n<flags.length; i++) flags[i*n] = true;
		}
		return flags;
	}

	public static void main(String[] args) {
		boolean[] primes = find(Integer.parseInt(args[0]));
		//System.out.println(Arrays.toString(primes));
		//for(int i=2; i<primes.length; i++) 
		//	if(!primes[i]) System.out.print(i + " ");
	} 
}