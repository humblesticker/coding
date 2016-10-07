public class MagicCube {
	void update(int[] nums, int iv, int jv, int kv, int[] range) {
		for(int i=0; i<3; i++) 
			for(int j=0; j<3; j++) {
				int sum = 0;
				for(int k=0; k<3; k++) sum += nums[i*iv + j*jv + k*kv];
				range[0] = Math.min(range[0], sum); 
				range[1] = Math.max(range[1], sum);
			}
	}
	
	int score(int[] nums) {
		int[] range = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
		update(nums, 9, 3, 1, range); 
		update(nums, 3, 1, 9, range);
		update(nums, 1, 9, 3, range);
		return range[1] - range[0];
	}
	
	void swap(int[] nums, int i, int j) {
		int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
	}
	
	public int getScore(int[] nums) {
		int min = score(nums);
		for(int i=0; i<nums.length; i++) 
			for(int j=i+1; j<nums.length; j++) {
				swap(nums, i, j);
				min = Math.min(min, score(nums)); 
				swap(nums, i, j);
			}
		return min;
	}
}