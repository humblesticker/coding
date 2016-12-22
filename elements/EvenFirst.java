/*
track position to insert next even
*/
import java.util.*;

public class EvenFirst {
	public static int[] process(int[] nums) {
		int pos = 0;
		for(int i=0; i<nums.length; i++) 
			if(nums[i]%2 == 0) { 
				int t = nums[pos]; nums[pos] = nums[i]; nums[i] = t;
				pos++;
			}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] nums = new int[s.nextInt()];
		for(int i=0; i<nums.length; i++) nums[i] = s.nextInt();
		System.out.println(Arrays.toString(process(nums)));
	}
}