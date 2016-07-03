import java.util.*;

public class VitosFamily {
	private static int dist(int[] nums, int i) {
		int d = 0;
		for(int n : nums) d += Math.abs(n-i);
		return d;
	}

	// 
	private static int min(int[] nums) {
		Arrays.sort(nums); 
		int min = Integer.MAX_VALUE;
		for(int i=nums[0]; i<=nums[nums.length-1]; i++) {
			int local = dist(nums, i); if(local >= min) break;
			min = local;
		}
		return min;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while(T > 0) {
			int[] nums = new int[s.nextInt()];
			for(int i=0; i<nums.length; i++) nums[i] = s.nextInt();
			System.out.println(min(nums));
			T--;
		}
	}
}