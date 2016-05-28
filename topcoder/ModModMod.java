/*
	for m in m[]
		project 1 to R into 0 to m-1
		for m and above update count track[r] 
*/
import java.util.*;

public class ModModMod {	
	public long findSum(int[] m, int R) {
		// initialize
		int[] track = new int[m[0]];
		for(int i=1; i<=R; i++) track[i%m[0]]++;

		int limit = m[0];
		for(int i=1; i<m.length; i++) {
			for(int j=m[i]+1; j<limit; j++) track[j%m[i]] += track[j];
			limit = m[i];
		}

		long sum = 0;
		for(int i=1; i<m[m.length-1]; i++) sum += i*track[i];
		return sum;	
	}

	public static void main(String[] args) {
		int[] m = new int[5000]; int start = 10000000;
		for(int i=0; i<m.length; i++) m[i] = start--;
		System.out.println((new ModModMod()).findSum(m, 10000000));
	}
}