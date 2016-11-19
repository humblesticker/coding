/*
DP
	-2, 4, 5, 6, -3, 4
	Sn = Max(Sn-1 + n, Sn-1) 

greedy


*/
import java.util.*;

public class MaxSubarray {
	int[] cache;
	int[] nums;

	MaxSubarray(int[] nums) {
		this.nums = nums; 
		cache = new int[nums.length];
		for(int i=0; i<cache.length; i++) cache[i] = -1;
	}

	int search(int i) {
		if(cache[i] >= 0) return cahce[i];
		int max = Math.max(search(i-1) + nums[i], search(i-1)));
		cache[i] = max;
		return max;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] nums = new int[s.nextInt()];
		for(int i=0; i<nums.length; i++) nums[i] = s.nextInt();
		System.out.println((new MaxSubarray(nums)).search(nums.length-1));
	}
}