import java.util.*;

public class JollyJumper {
	private static boolean jolly(int[] nums) {
		boolean[] flags = new boolean[nums.length];
		for(int i=1; i<nums.length; i++) {
			int diff = Math.abs(nums[i] - nums[i-1]); if(diff <= 0 || diff > flags.length-1 || flags[diff]) return false;
			flags[diff] = true; 
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()) {
			int[] nums = new int[s.nextInt()];
			for(int i=0; i<nums.length; i++) nums[i] = s.nextInt();

			if(jolly(nums))	System.out.println("Jolly");
			else System.out.println("Not jolly");
		}
	}
}