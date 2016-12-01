/*
sort and get n1 first, then n2 second
small one first
 */
import java.util.*;

public class Urbanization {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), n1 = s.nextInt(), n2 = s.nextInt();
		if(n1 > n2) { int temp = n1; n1 = n2; n2 = temp; };

		List<Integer> nums = new ArrayList<Integer>();
		while(n-- > 0) nums.add(s.nextInt());
		Collections.sort(nums, Collections.reverseOrder());

		long sum1 = 0;
		for(int i=0; i<n1; i++) sum1 += nums.get(i);

		long sum2 = 0;
		for(int i=n1; i<n1+n2; i++) sum2 += nums.get(i);

		System.out.println((double)sum1/n1 + (double)sum2/n2);
	}
}