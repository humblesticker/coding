/*
Fibonacci 
*/
import java.util.*;

public class Tennis {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong(), wins = 1, prev = 1, current = 2;
		while(current < n) {
			long next = prev + current; 
			prev = current; current = next;  wins++;
		}

		if(current == n) System.out.println(wins);
		else System.out.println(wins-1);
	}
}