/*
fill from both ends
track low, high
~ O(n)
	with O(n) space -- easy
	inline -- tricky

edge case
	smallest
	largest
*/
import java.util.*;

public class DutchPartition {
	void swap(int[] nums, int i, int j) {
		int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
	}

	public int[] run(int[] nums, int pos) {
		int i = 0, low = 0, high = nums.length-1, val = nums[pos];
		while(i < high) { // i >= low 
			if(nums[i] > val) swap(nums, i, high--);
			else if(nums[i] < val) swap(nums, i++, low++);
			else i++;
		}
		return nums;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] nums = new int[s.nextInt()];
		for(int i=0; i<nums.length; i++) nums[i] = s.nextInt();
		System.out.println(Arrays.toString((new DutchPartition()).run(nums, s.nextInt())));
	}
}