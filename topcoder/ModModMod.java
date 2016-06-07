import java.util.*;

public class ModModMod {	
	public long findSum(int[] m, int R) {
		int[] track = new int[m[0]];
		for(int i=1; i<=R; i++) track[i%m[0]]++;

		int limit = m[0];
		for(int i=1; i<m.length; i++) {
			for(int j=m[i]+1; j<limit; j++) track[j%m[i]] += track[j];
			if(m[i] < limit) limit = m[i];
		}

		long sum = 0;
		for(int i=1; i<limit; i++) sum += i*track[i];
		return sum;	
	}
}