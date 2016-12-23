/*
very large number of 64 bit words
look up table
	16, 16, 16, 16
*/
import java.util.*;

public class Parity {
	int[] cache; CountOne counter;
	public Parity() { 
		cache = new int[65536];
		for(int i=0; i<cache.length; i++) cache[i] = -1;
		counter = new CountOne();
	}

	int get(long number) {
		int n = (int)(number & 0xFFFF);
		if(cache[n] < 0) cache[n] = counter.count(n) % 2;
		return cache[n];
	}

	public int calculate(long n) {
		int n1 = get(n); n >>>= 16;
		int n2 = get(n); n >>>= 16;
		int n3 = get(n); n >>>= 16;
		return (n1 + n2 + n3 + get(n))%2;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()) System.out.println((new Parity()).calculate(s.nextLong()));
	}
}