/*

*/
public class Permutation {
    void reverse(int[] nums, int i) {
        int j = nums.length-1;
        while(i < j) { swap(nums, i, j); i++; j--; }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }
    
    public void nextPermutation(int[] nums) {
        int i=length-1;
        while(i > 0) {
            if(nums[i] > nums[i-1]) break;
            i--;
        }

        reverse(nums, i); int pos = i;
        if(i > 0) {
            while(i < nums.length) { 
                if(nums[i] > nums[pos]) { swap(i, pos); break; }
                i++;
            }
        }
    }
}