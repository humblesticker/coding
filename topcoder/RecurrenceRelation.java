/*
	table = int[N+1]
	initialize table with init
	i from k to N
		sum = add coef * table from i-1 to i-k
		update table[i] = sum%10 if(sum < 0) 10 - (-sum%10)
*/
import java.util.*;

public class RecurrenceRelation {
	private int modulo(int n) {
		if(n>=0) return n%10;
		else return (10 - ((-n)%10))%10;	
	}
	
	public int moduloTen(int[] coef, int[] init, int N) {
		int[] table = new int[100001];
		for(int i=0; i<init.length; i++) table[i] = modulo(init[i]);

		int k = init.length;
		for(int i=k; i<=N; i++) {
			int sum = 0;
			for(int j=i-k; j<i; j++) {
				//System.out.println(i + "," + j);
				sum += (coef[j-i+k] * table[j]);
			}
			
			table[i] = modulo(sum);
			//System.out.println(sum); 
			//System.out.println(Arrays.toString(table));
		}

		return table[N];
	}
}