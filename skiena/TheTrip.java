import java.util.*;
import java.text.*;

public class TheTrip {
	private static DecimalFormat df2 = new DecimalFormat("$0.00");

	// 10.00 -> 1000
	// total doesn't matter. 
	// focus on spending within one cent
	private static int exchange(int[] spending) {
		int sum = 0; for(int n : spending) sum += n;
		int avg = sum/spending.length;

		int pay = 0, receive = 0;
		for(int n : spending) {
			if(n > avg) receive += (n - avg - 1);
			else pay += (avg - n);
		}
		
		if(pay > receive) return pay;
		return receive;
	}

	private static int parse(String str) {
		String[] array = str.split("\\.");
		return Integer.parseInt(array[0])*100 + Integer.parseInt(array[1]);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			int n = s.nextInt(); if(n == 0) break;
			int[] spending = new int[n];
			for(int i=0; i<n; i++) spending[i] = parse(s.next());
			System.out.println(df2.format(exchange(spending)/100.0));
		}
	}
}