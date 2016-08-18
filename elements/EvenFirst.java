/*
odd index
while i <= odd
	if even continue
	swap nums[odd] and nums[i] update odd
*/
import java.util.*;

public class EvenFirst {
	public static int[] process(int[] nums) {
		int odd = nums.length-1, i = 0;
		while(i < odd) {
			if(nums[i]%2 == 0) i++;
			else {
				int temp = nums[odd]; nums[odd] = nums[i]; nums[i] = temp;
				odd--;
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] nums = new int[s.nextInt()];
		for(int i=0; i<nums.length; i++) nums[i] = s.nextInt();
		System.out.println(Arrays.toString(process(nums)));
	}
}