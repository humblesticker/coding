/*
sorted 1, 2, 2, 3, 4, 4, 4, 5
track last pos of distinct
*/
import java.util.*;

public class RemoveDuplicate {
	public static int[] process(int[] nums) {
		int pos = 0;
		for(int i=1; i<nums.length; i++) 
			if(nums[i] != nums[pos]) {
				pos++;
				int t = nums[pos]; nums[pos] = nums[i]; nums[i] = t;
			} 

		return Arrays.copyOfRange(nums, 0, pos+1);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] nums = new int[s.nextInt()];
		for(int i=0; i<nums.length; i++) nums[i] = s.nextInt();
		System.out.println(Arrays.toString(process(nums)));
	}
}